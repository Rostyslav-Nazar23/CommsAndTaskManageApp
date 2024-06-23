package com.rnazarapps.commsandtaskmanageapp.retrofit

import com.rnazarapps.commsandtaskmanageapp.model.Task

// TaskRepository
class TaskRepository(private val taskApi: TaskApi) {

    suspend fun getAllTasks(): List<Task> {
        return taskApi.getAllTasks()
    }

    suspend fun getTaskById(id: Long): Task {
        return taskApi.getTaskById(id)
    }

    suspend fun createTask(task: Task): Task {
        return taskApi.createTask(task)
    }

    suspend fun updateTask(task: Task): Task {
        return taskApi.updateTask(task.id, task)
    }

    suspend fun deleteTask(id: Long) {
        taskApi.deleteTask(id)
    }
}