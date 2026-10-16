package com.example

import android.content.Context
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UsbRepository(context: Context) {
    private val usbManager = context.getSystemService(Context.USB_SERVICE) as UsbManager
    
    private val _connectedDevices = MutableStateFlow<List<UsbDevice>>(emptyList())
    val connectedDevices: StateFlow<List<UsbDevice>> = _connectedDevices

    fun updateDevices() {
        _connectedDevices.value = usbManager.deviceList.values.toList()
    }
}
