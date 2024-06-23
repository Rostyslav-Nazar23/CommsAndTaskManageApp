package com.rnazarapps.commsandtaskmanageapp.retrofit

import com.rnazarapps.commsandtaskmanageapp.model.Message
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

// Retrofit API для Message
interface MessageApi {
    @GET("messages")
    suspend fun getAllMessages(): List<Message>

    @GET("messages/{id}")
    suspend fun getMessageById(@Path("id") id: Long): Message

    @POST("messages")
    suspend fun createMessage(@Body message: Message): Message

    @PUT("messages/{id}")
    suspend fun updateMessage(@Path("id") id: Long, @Body message: Message): Message

    @DELETE("messages/{id}")
    suspend fun deleteMessage(@Path("id") id: Long)
}