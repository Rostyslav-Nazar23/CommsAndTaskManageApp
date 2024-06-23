package com.rnazarapps.commsandtaskmanageapp.model

import com.google.gson.annotations.SerializedName

// Клас для серверів
data class Server(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("textChannels") val textChannels: List<TextChannel>,
    @SerializedName("taskChannels") val taskChannels: List<TaskChannel>
)