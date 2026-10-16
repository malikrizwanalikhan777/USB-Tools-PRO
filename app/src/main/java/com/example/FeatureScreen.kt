package com.example

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FeatureScreen(title: String, content: @Composable () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        AppHeader(title)
        Column(modifier = Modifier.padding(16.dp)) {
            // Explicitly set text color for visibility
            CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.onBackground) {
                content()
            }
        }
    }
}
