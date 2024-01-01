package com.practice.deviceinfo.models

data class Device(
    val manufacturer: String,
    val brand : String,
    val model: String,
    val board: String,
    val hardware: String,
    val androidId: String,
    val screenResolution: String,
    val bootloader: String,
    val user: String,
    val host: String,
)
