package com.rnazarapps.commsandtaskmanageapp.ui.compose.screens

import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rnazarapps.commsandtaskmanageapp.ui.compose.structures.DrawerContent
import com.rnazarapps.commsandtaskmanageapp.viewmodel.MessageViewModel
import com.rnazarapps.commsandtaskmanageapp.viewmodel.TaskViewModel
import kotlinx.coroutines.launch

@Composable
fun AppUI(taskVM: TaskViewModel, msgVM: MessageViewModel) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(navController, drawerState)
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Task Management") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) {
            with(it) {
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { HomeScreen(navController) }
                    composable("messages") { MessageScreen(viewModel = msgVM) }
                    composable("tasks") { TaskScreen(viewModel = taskVM) }
                }
            }
        }
    }
}