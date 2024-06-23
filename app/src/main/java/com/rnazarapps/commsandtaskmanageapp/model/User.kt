package com.rnazarapps.commsandtaskmanageapp.model

import com.google.gson.annotations.SerializedName

// Клас для користувачів
data class User(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("login") val login: String,
    @SerializedName("password") val password: String
)
