package com.rnazarapps.commsandtaskmanageapp.ui.compose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*

@Composable
fun HomeScreen(navController: NavHostController) {
    Row(Modifier.fillMaxSize()) {
        Column(Modifier.width(200.dp).padding(16.dp)) {
            Text("Channels", style = MaterialTheme.typography.h6)
            val channels = listOf("General", "Random", "Tasks")
            channels.forEach { channel ->
                Text(
                    text = channel,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            when (channel) {
                                "General" -> navController.navigate("messages")
                                "Tasks" -> navController.navigate("tasks")
                            }
                        }
                )
            }
        }
        Box(Modifier.fillMaxSize()) {
            Text("Select a channel from the left", modifier = Modifier.align(Alignment.Center))
        }
    }
}