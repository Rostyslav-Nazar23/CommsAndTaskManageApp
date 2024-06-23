package com.rnazarapps.commsandtaskmanageapp.websocket

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

    override fun onOpen(webSocket: WebSocket, response: Response) {
        super.onOpen(webSocket, response)
        println("WebSocket Opened: ${response.message}")
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        super.onMessage(webSocket, text)
        // Assuming the server sends updates in a unified format to distinguish between tasks and messages
        val update = parseUpdate(text)
        when (update.type) {
            "message" -> {
                val updatedMessages = messagesFlow.value.toMutableList()
                update.message?.let { updatedMessages.add(it) }
                messagesFlow.value = updatedMessages
            }
            "task" -> {
                val updatedTasks = tasksFlow.value.toMutableList()
                update.task?.let { updatedTasks.add(it) }
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

    private fun parseUpdate(text: String): Update {
        // Implement JSON parsing logic to convert text to Update
        return Update(type = "message", message = Message(...), task = Task(...))
    }
}

data class Update(val type: String, val message: Message?, val task: Task?)