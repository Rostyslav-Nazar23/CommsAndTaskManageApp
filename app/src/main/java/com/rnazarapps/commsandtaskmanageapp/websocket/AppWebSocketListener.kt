package com.rnazarapps.commsandtaskmanageapp.websocket

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.rnazarapps.commsandtaskmanageapp.model.Message
import com.rnazarapps.commsandtaskmanageapp.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString

class AppWebSocketListener(
    private val messagesFlow: MutableStateFlow<List<Message>>,
    private val tasksFlow: MutableStateFlow<List<Task>>
) : WebSocketListener() {

    private val gson = Gson()

    override fun onOpen(webSocket: WebSocket, response: Response) {
        super.onOpen(webSocket, response)
        println("WebSocket Opened: ${response.message}")
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        super.onMessage(webSocket, text)
        // Парсинг JSON повідомлення
        val jsonObject = gson.fromJson(text, JsonObject::class.java)
        when (jsonObject["type"].asString) {
            "message" -> {
                val message = gson.fromJson(jsonObject["data"], Message::class.java)
                val updatedMessages = messagesFlow.value.toMutableList()
                updatedMessages.add(message)
                messagesFlow.value = updatedMessages
            }
            "task" -> {
                val task = gson.fromJson(jsonObject["data"], Task::class.java)
                val updatedTasks = tasksFlow.value.toMutableList()
                updatedTasks.add(task)
                tasksFlow.value = updatedTasks
            }
        }
    }

    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
        super.onMessage(webSocket, bytes)
        println("WebSocket ByteString Received: ${bytes.hex()}")
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        super.onClosing(webSocket, code, reason)
        webSocket.close(code, reason)
        println("WebSocket Closing: $code / $reason")
    }

    override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
        super.onClosed(webSocket, code, reason)
        println("WebSocket Closed: $code / $reason")
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        super.onFailure(webSocket, t, response)
        println("WebSocket Failure: ${t.message}")
    }
}

//data class Update(val type: String, val message: Message?, val task: Task?)