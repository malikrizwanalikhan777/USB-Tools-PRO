package com.example

import java.util.Locale

fun isChina(): Boolean {
    return Locale.getDefault().country == "CN"
}

fun getLocalizedString(key: String): String {
    val isChina = isChina()
    val strings = if (isChina) {
        mapOf(
            "app_name" to "USB工具专业版",
            "dashboard" to "仪表板",
            "caution" to "警告：格式化操作不可逆，将导致数据丢失。"
        )
    } else {
        mapOf(
            "app_name" to "USB Tools Pro",
            "dashboard" to "Dashboard",
            "caution" to "Caution: Formatting is irreversible and will result in data loss."
        )
    }
    return strings[key] ?: key
}
