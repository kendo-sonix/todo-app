package com.example.todo.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.todo.ui.screen.AppLaunchScreen
import com.example.todo.ui.theme.TodoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoApp()
        }
    }
}

@Composable
fun TodoApp() {
    AppLaunchScreen()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TodoTheme {
        TodoApp()
    }
}
