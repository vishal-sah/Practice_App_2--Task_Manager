package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskManager(status, message)
                }
            }
        }
    }
}

var status = "All tasks completed"
var message = "Nice Work!"

@Composable
fun TaskManager(status: String, message: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
    ) {
        val image = painterResource(id = R.drawable.ic_task_completed)
        Image(
            image,
            null,
            modifier = Modifier
                .padding(8.dp)
                .align(CenterHorizontally)
        )
        Text(
            status,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(start = 0.dp, top = 24.dp, end = 0.dp, bottom = 8.dp)
        )
        Text(
            message,
            fontSize = 15.sp,
            modifier = Modifier
                    .align(CenterHorizontally)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
    TaskManagerTheme {
        TaskManager(status, message)
    }
}