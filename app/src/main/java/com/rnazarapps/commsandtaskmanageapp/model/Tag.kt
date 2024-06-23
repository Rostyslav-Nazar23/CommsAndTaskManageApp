package com.rnazarapps.commsandtaskmanageapp.model

import com.google.gson.annotations.SerializedName

// Клас для міток задач
data class Tag(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("color") val color: Int
)