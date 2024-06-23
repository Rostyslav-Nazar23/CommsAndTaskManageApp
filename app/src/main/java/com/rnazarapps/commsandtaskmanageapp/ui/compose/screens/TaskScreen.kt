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
import com.rnazarapps.commsandtaskmanageapp.viewmodel.TaskViewModel

@Composable
fun TaskScreen(viewModel: TaskViewModel) {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Tasks", style = MaterialTheme.typography.h4)
        val tasks by viewModel.tasks.collectAsState()
        tasks.forEach { task ->
            Text(text = task.toString(), modifier = Modifier.padding(8.dp))
        }
    }
}