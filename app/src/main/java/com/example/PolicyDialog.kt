package com.example

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun PolicyDialog(onDismiss: () -> Unit) {
    var accepted by remember { mutableStateOf(false) }
    Dialog(onDismissRequest = {}) {
        Surface(modifier = Modifier.padding(16.dp), shape = MaterialTheme.shapes.medium) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Privacy Policy & Terms", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(16.dp))
                Text("USB Tools Pro respects your privacy. We do not track, share, or sell your data. Formatting storage devices is a destructive operation. By using this application, you acknowledge that you are responsible for any data loss occurring from formatting or manipulating storage volumes. We do not guarantee compatibility with all USB devices or filesystems. Use this tool at your own risk. Our application does not have access to internal device storage partitions. Ensure you have backed up all data before proceeding. Access to USB hosts requires your explicit permission. Continued use constitutes acceptance of these terms.")
                Spacer(modifier = Modifier.height(16.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = accepted, onCheckedChange = { accepted = it })
                    Text("I accept the terms")
                }
                Button(onClick = onDismiss, enabled = accepted) { Text("Proceed") }
            }
        }
    }
}
