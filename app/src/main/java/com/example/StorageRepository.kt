package com.example

import android.content.Context
import android.os.storage.StorageManager
import android.os.storage.StorageVolume
import androidx.annotation.RequiresApi
import android.os.Build

class StorageRepository(context: Context) {
    private val storageManager = context.getSystemService(Context.STORAGE_SERVICE) as StorageManager

    @RequiresApi(Build.VERSION_CODES.N)
    fun getStorageVolumes(): List<StorageVolume> {
        return storageManager.storageVolumes
    }
}
