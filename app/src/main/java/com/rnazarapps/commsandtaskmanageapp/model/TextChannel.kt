package com.rnazarapps.commsandtaskmanageapp.model

import com.google.gson.annotations.SerializedName

// Клас для текстових каналів
data class TextChannel(
    @SerializedName("id") val id: Long,
    @SerializedName("serverId") val serverId: Long,
    @SerializedName("name") val name: String,
    @SerializedName("roles") val roles: List<Role>,
    @SerializedName("messages") val messages: List<Message>
)