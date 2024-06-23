package com.rnazarapps.commsandtaskmanageapp.retrofit

import com.rnazarapps.commsandtaskmanageapp.model.Task
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

// Retrofit API для Task
interface TaskApi {
    @GET("tasks")
    suspend fun getAllTasks(): List<Task>

    @GET("tasks/{id}")
    suspend fun getTaskById(@Path("id") id: Long): Task

    @POST("tasks")
    suspend fun createTask(@Body task: Task): Task

    @PUT("tasks/{id}")
    suspend fun updateTask(@Path("id") id: Long, @Body task: Task): Task

    @DELETE("tasks/{id}")
    suspend fun deleteTask(@Path("id") id: Long)
}