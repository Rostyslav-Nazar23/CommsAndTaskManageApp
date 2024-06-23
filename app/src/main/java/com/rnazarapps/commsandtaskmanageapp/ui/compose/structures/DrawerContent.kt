package com.rnazarapps.commsandtaskmanageapp.ui.compose.structures

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DrawerState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch

@Composable
fun DrawerContent(navController: NavHostController, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    Column {
        Text("Servers", style = MaterialTheme.typography.h6, modifier = Modifier.padding(16.dp))
        val servers = listOf("Server 1", "Server 2", "Server 3")
        servers.forEach { server ->
            Text(
                text = server,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable {
                        // Handle server click
                        scope.launch {
                            drawerState.close()
                        }
                    }
            )
        }
    }
}