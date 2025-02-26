package com.example.todo.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo.ui.screen.AppLaunchScreen
import com.example.todo.ui.screen.LoginScreen
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
    val navController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        NavHost(
            navController = navController,
            startDestination = Navigate.APP_LAUNCH.name
        ) {
            // アプリ起動
            composable(route = Navigate.APP_LAUNCH.name) {
                AppLaunchScreen(
                    navigateTo = { navController.navigate(Navigate.LOGIN.name) }
                )
            }

            // ログイン
            composable(route = Navigate.LOGIN.name) { LoginScreen() }
        }
    }
}

enum class Navigate {
    /** アプリ起動 */
    APP_LAUNCH,

    /** ログイン */
    LOGIN
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TodoTheme {
        TodoApp()
    }
}
