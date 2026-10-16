package com.example

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainViewModel(
    val usbRepository: UsbRepository,
    val storageRepository: StorageRepository
) : androidx.lifecycle.ViewModel() {
    init {
        usbRepository.updateDevices()
    }
}
