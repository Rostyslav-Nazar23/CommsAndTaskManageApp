package com.rnazarapps.commsandtaskmanageapp.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

// Клас для коментарів до задач
data class Comment(
    @SerializedName("id") val id: Long,
    @SerializedName("taskId") val taskId: Long,
    @SerializedName("text") val text: String,
    @SerializedName("authorId") val authorId: Long,
    @SerializedName("timestamp") val timestamp: LocalDateTime
)