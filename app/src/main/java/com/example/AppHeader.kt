package com.example

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppHeader(title: String) {
    Surface(modifier = Modifier.fillMaxWidth().height(80.dp), color = Color(0xFF2196F3)) {
        Box(contentAlignment = Alignment.CenterStart, modifier = Modifier.padding(16.dp)) {
            Text(title, style = MaterialTheme.typography.headlineSmall, color = Color.White)
        }
    }
}
