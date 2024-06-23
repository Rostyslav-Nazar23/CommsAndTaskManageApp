package com.rnazarapps.commsandtaskmanageapp.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

// Клас для задач
data class Task(
    @SerializedName("id") val id: Long,
    @SerializedName("taskChannelId") val taskChannelId: Long,
    @SerializedName("startTime") val startTime: LocalDateTime?,
    @SerializedName("endTime") val endTime: LocalDateTime?,
    @SerializedName("executors") val executors: List<User>,
    @SerializedName("comments") val comments: List<Comment>,
    @SerializedName("tags") val tags: List<Tag>
)