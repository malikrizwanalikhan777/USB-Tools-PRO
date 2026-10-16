package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ui.theme.MyApplicationTheme
import com.example.FeatureScreen
import com.example.FormatScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val context = androidx.compose.ui.platform.LocalContext.current
                val navController = rememberNavController()
                val viewModel = remember { MainViewModel(UsbRepository(context), StorageRepository(context)) }
                var showPolicy by remember { mutableStateOf(true) }
                
                if (showPolicy) {
                    PolicyDialog(onDismiss = { showPolicy = false })
                }

                NavHost(
                    navController = navController,
                    startDestination = "dashboard"
                ) {
                    composable("dashboard") { DashboardScreen(viewModel, onNavigate = { navController.navigate(it) }) }
                    composable("usb_info") { FeatureScreen(getLocalizedString("dashboard")) { Text(getLocalizedString("caution"), color = MaterialTheme.colorScheme.onBackground) } }
                    composable("storage_info") { FeatureScreen(getLocalizedString("dashboard")) { Text("USB storage capacity and file system details will be displayed here.", color = MaterialTheme.colorScheme.onBackground) } }
                    composable("format_usb") { FormatScreen("Format USB") }
                    composable("format_sd") { FormatScreen("Format SD Card") }
                    composable("troubleshooting") { FeatureScreen("Troubleshooting") { Text("USB connection troubleshooting guide will be displayed here.", color = MaterialTheme.colorScheme.onBackground) } }
                    composable("settings") { FeatureScreen("Settings") { Text("App settings and configuration will be displayed here.", color = MaterialTheme.colorScheme.onBackground) } }
                }
            }
        }
    }
}
