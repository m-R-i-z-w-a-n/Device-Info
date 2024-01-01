package com.practice.deviceinfo.models

data class OS(
    val version: String,
    val versionName: String,
    val apiLevel:String,
    val buildId: String,
    val buildTime: String,
    val fingerprint: String
)
