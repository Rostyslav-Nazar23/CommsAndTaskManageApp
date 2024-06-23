package com.rnazarapps.commsandtaskmanageapp.model

import com.google.gson.annotations.SerializedName

// Клас для ролей
data class Role(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String
)