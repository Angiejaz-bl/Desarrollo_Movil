package com.example.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.activity.ui.navigation.AppNavigation
import com.example.activity.ui.theme.ActivityTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            ActivityTheme {

                AppNavigation()
            }
        }
    }
}