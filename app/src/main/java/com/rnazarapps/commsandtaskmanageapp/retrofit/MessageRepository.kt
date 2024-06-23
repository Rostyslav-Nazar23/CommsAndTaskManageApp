package com.rnazarapps.commsandtaskmanageapp.retrofit

import com.rnazarapps.commsandtaskmanageapp.model.Message

// MessageRepository
class MessageRepository(private val messageApi: MessageApi) {

    suspend fun getAllMessages(): List<Message> {
        return messageApi.getAllMessages()
    }

    suspend fun getMessageById(id: Long): Message {
        return messageApi.getMessageById(id)
    }

    suspend fun createMessage(message: Message): Message {
        return messageApi.createMessage(message)
    }

    suspend fun updateMessage(message: Message): Message {
        return messageApi.updateMessage(message.id, message)
    }

    suspend fun deleteMessage(id: Long) {
        messageApi.deleteMessage(id)
    }
}