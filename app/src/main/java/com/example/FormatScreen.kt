package com.example

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormatScreen(title: String) {
    var fsExpanded by remember { mutableStateOf(false) }
    var selectedFs by remember { mutableStateOf("FAT32") }

    FeatureScreen(title) {
        Column {
            // File System Dropdown
            ExposedDropdownMenuBox(
                expanded = fsExpanded,
                onExpandedChange = { fsExpanded = !fsExpanded }
            ) {
                OutlinedTextField(
                    value = selectedFs,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("File System") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = fsExpanded) },
                    modifier = Modifier.fillMaxWidth().menuAnchor()
                )
                ExposedDropdownMenu(expanded = fsExpanded, onDismissRequest = { fsExpanded = false }) {
                    listOf("FAT16", "FAT32", "EXFAT", "NTFS", "EXT2", "EXT3", "EXT4").forEach { fs ->
                        DropdownMenuItem(text = { Text(fs) }, onClick = { selectedFs = fs; fsExpanded = false })
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Volume Label
            var label by remember { mutableStateOf("") }
            OutlinedTextField(value = label, onValueChange = { label = it }, label = { Text("Volume Label") }, modifier = Modifier.fillMaxWidth())
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Button(onClick = { /* Trigger honest action */ }, modifier = Modifier.fillMaxWidth()) {
                Text("FORMAT")
            }
        }
    }
}
