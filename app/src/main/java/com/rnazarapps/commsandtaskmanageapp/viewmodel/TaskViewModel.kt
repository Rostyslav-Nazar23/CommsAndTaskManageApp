package com.rnazarapps.commsandtaskmanageapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rnazarapps.commsandtaskmanageapp.model.Task
import com.rnazarapps.commsandtaskmanageapp.retrofit.TaskRepository
import com.rnazarapps.commsandtaskmanageapp.websocket.AppWebSocketListener
import com.rnazarapps.commsandtaskmanageapp.websocket.WebSocketManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskViewModel(private val taskRepository: TaskRepository) : ViewModel() {

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> get() = _tasks

    private val webSocketManager: WebSocketManager

    init {
        loadTasks()

        val listener = AppWebSocketListener(tasksFlow = _tasks, messagesFlow = MutableStateFlow(emptyList()))
        webSocketManager = WebSocketManager(serverUrl = "ws://localhost:5999/ws", listener = listener)
        webSocketManager.start()
    }

    private fun loadTasks() {
        viewModelScope.launch {
            _tasks.value = taskRepository.getAllTasks()
        }
    }

    fun getTaskById(id: Long) {
        viewModelScope.launch {
            _tasks.value = _tasks.value.map { if (it.id == id) taskRepository.getTaskById(id) else it }
        }
    }

    fun createTask(task: Task) {
        viewModelScope.launch {
            taskRepository.createTask(task)
            loadTasks()
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            taskRepository.updateTask(task)
            loadTasks()
        }
    }

    fun deleteTask(id: Long) {
        viewModelScope.launch {
            taskRepository.deleteTask(id)
            loadTasks()
        }
    }

    override fun onCleared() {
        super.onCleared()
        webSocketManager.close(1000, "ViewModel cleared")
    }
}
