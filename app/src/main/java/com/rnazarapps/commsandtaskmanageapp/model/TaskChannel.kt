package com.rnazarapps.commsandtaskmanageapp.model

import com.google.gson.annotations.SerializedName

// Клас для каналів із задачами
data class TaskChannel(
    @SerializedName("id") val id: Long,
    @SerializedName("serverId") val serverId: Long,
    @SerializedName("name") val name: String,
    @SerializedName("tasks") val tasks: List<Task>
)