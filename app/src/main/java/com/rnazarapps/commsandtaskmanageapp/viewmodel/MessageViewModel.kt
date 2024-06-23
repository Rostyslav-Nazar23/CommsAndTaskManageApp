package com.rnazarapps.commsandtaskmanageapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rnazarapps.commsandtaskmanageapp.model.Message
import com.rnazarapps.commsandtaskmanageapp.retrofit.MessageRepository
import com.rnazarapps.commsandtaskmanageapp.websocket.AppWebSocketListener
import com.rnazarapps.commsandtaskmanageapp.websocket.WebSocketManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MessageViewModel(private val messageRepository: MessageRepository) : ViewModel() {

    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> get() = _messages

    private val webSocketManager: WebSocketManager

    init {
        loadMessages()

        val listener = AppWebSocketListener(messagesFlow = _messages, tasksFlow = MutableStateFlow(emptyList()))
        webSocketManager = WebSocketManager(serverUrl = "ws://localhost:5999/ws", listener = listener)
        webSocketManager.start()
    }

    private fun loadMessages() {
        viewModelScope.launch {
            _messages.value = messageRepository.getAllMessages()
        }
    }

    fun getMessageById(id: Long) {
        viewModelScope.launch {
            _messages.value = _messages.value.map { if (it.id == id) messageRepository.getMessageById(id) else it }
        }
    }

    fun createMessage(message: Message) {
        viewModelScope.launch {
            messageRepository.createMessage(message)
            loadMessages()
        }
    }

    fun updateMessage(message: Message) {
        viewModelScope.launch {
            messageRepository.updateMessage(message)
            loadMessages()
        }
    }

    fun deleteMessage(id: Long) {
        viewModelScope.launch {
            messageRepository.deleteMessage(id)
            loadMessages()
        }
    }

    override fun onCleared() {
        super.onCleared()
        webSocketManager.close(1000, "ViewModel cleared")
    }
}
