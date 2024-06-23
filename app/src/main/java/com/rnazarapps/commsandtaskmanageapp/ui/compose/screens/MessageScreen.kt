package com.rnazarapps.commsandtaskmanageapp.ui.compose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rnazarapps.commsandtaskmanageapp.viewmodel.MessageViewModel

@Composable
fun MessageScreen(viewModel: MessageViewModel) {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Messages", style = MaterialTheme.typography.h4)
        val messages by viewModel.messages.collectAsState()
        messages.forEach { message ->
            Text(text = message.text, modifier = Modifier.padding(8.dp))
        }
    }
}