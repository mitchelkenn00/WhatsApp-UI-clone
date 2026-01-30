package com.example.wahtsapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.wahtsapp.navigation.WhatsAppNavGraph
import com.example.wahtsapp.presentation.theme.WahtsappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enables immersive 'behind the status bar' UI
        enableEdgeToEdge()

        setContent {
            WahtsappTheme {
                // Surface provides the background color from your theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // The master navigation controller
                    WhatsAppNavGraph()
                }
            }
        }
    }
}