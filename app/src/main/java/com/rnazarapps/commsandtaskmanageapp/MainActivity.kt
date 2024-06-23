package com.rnazarapps.commsandtaskmanageapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.rnazarapps.commsandtaskmanageapp.ui.compose.screens.AppUI
import com.rnazarapps.commsandtaskmanageapp.ui.theme.CommsAndTaskManageAppTheme
import com.rnazarapps.commsandtaskmanageapp.viewmodel.MessageViewModel
import com.rnazarapps.commsandtaskmanageapp.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val taskVM: TaskViewModel by viewModels()
        val msgVM: MessageViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            CommsAndTaskManageAppTheme {
                AppUI(taskVM = taskVM, msgVM = msgVM)
            }
        }
    }
}
