package com.rnazarapps.commsandtaskmanageapp.websocket

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener

class WebSocketManager(
    private val serverUrl: String,
    private val listener: WebSocketListener
) {
    private val client = OkHttpClient()
    private lateinit var webSocket: WebSocket

    fun start() {
        val request = Request.Builder().url(serverUrl).build()
        webSocket = client.newWebSocket(request, listener)
    }

    fun send(message: String) {
        webSocket.send(message)
    }

    fun close(code: Int, reason: String) {
        webSocket.close(code, reason)
    }
}