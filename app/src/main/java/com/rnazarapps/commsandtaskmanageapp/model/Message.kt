package com.rnazarapps.commsandtaskmanageapp.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

// Клас для повідомлень
data class Message(
    @SerializedName("id") val id: Long,
    @SerializedName("textChannelId") val textChannelId: Long,
    @SerializedName("authorId") val authorId: Long,
    @SerializedName("text") val text: String,
    @SerializedName("timestamp") val timestamp: LocalDateTime
)