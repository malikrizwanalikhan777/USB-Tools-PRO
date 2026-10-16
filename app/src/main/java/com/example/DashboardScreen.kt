package com.example

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

data class DashboardItem(val title: String, val icon: ImageVector, val route: String)

@Composable
fun DashboardScreen(viewModel: MainViewModel, onNavigate: (String) -> Unit) {
    val items = listOf(
        DashboardItem("USB Info", Icons.Default.Info, "usb_info"),
        DashboardItem("Storage Info", Icons.Default.Storage, "storage_info"),
        DashboardItem("Format USB", Icons.Default.Build, "format_usb"),
        DashboardItem("Format SD Card", Icons.Default.SdCard, "format_sd"),
        DashboardItem("Troubleshooting", Icons.Default.Warning, "troubleshooting"),
        DashboardItem("Settings", Icons.Default.Settings, "settings")
    )

    Column(modifier = Modifier.fillMaxSize()) {
        AppHeader(getLocalizedString("app_name"))
        Column(modifier = Modifier.padding(16.dp)) {
            // USB Status Card
            Card(
                modifier = Modifier.fillMaxWidth().height(120.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Device: No Device", style = MaterialTheme.typography.titleMedium)
                    Text("Size: N/A", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.weight(1f))
                    Button(onClick = { /* Implement Eject */ }, modifier = Modifier.align(Alignment.End)) {
                        Text("Eject")
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Tool Cards
            LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                items(items) { item ->
                    Card(
                        modifier = Modifier.fillMaxWidth().height(70.dp).clickable { onNavigate(item.route) },
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize().padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(item.title, style = MaterialTheme.typography.titleMedium)
                        }
                    }
                }
            }
        }
    }
}
