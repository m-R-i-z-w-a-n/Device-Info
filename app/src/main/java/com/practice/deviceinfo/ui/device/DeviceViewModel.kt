package com.practice.deviceinfo.ui.device

import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DeviceViewModel : ViewModel() {
    private val _deviceManufacturer = MutableLiveData<String>()
    private val _deviceBrand = MutableLiveData<String>()
    private val _deviceModel = MutableLiveData<String>()
    private val _deviceBoard = MutableLiveData<String>()
    private val _deviceHardware = MutableLiveData<String>()
    private val _deviceAndroidId = MutableLiveData<String>()
    private val _deviceScreenResolution = MutableLiveData<String>()
    private val _deviceBootloader = MutableLiveData<String>()
    private val _deviceUser = MutableLiveData<String>()
    private val _deviceHost = MutableLiveData<String>()


    val deviceManufacturer: LiveData<String>
        get() = _deviceManufacturer
    val deviceBrand: LiveData<String>
        get() = _deviceBrand
    val deviceModel: LiveData<String>
        get() = _deviceModel
    val deviceBoard: LiveData<String>
        get() = _deviceBoard
    val deviceHardware: LiveData<String>
        get() = _deviceHardware
    val deviceAndroidId: LiveData<String>
        get() = _deviceAndroidId
    val deviceScreenResolution: LiveData<String>
        get() = _deviceScreenResolution
    val deviceBootloader: LiveData<String>
        get() = _deviceBootloader
    val deviceUser: LiveData<String>
        get() = _deviceUser
    val deviceHost: LiveData<String>
        get() = _deviceHost

    fun getDeviceInfo() {
        _deviceManufacturer.postValue(Build.MANUFACTURER.toString())
        _deviceBrand.postValue(Build.BRAND.toString())
        _deviceModel.postValue(Build.MODEL.toString())
        _deviceBoard.postValue(Build.BOARD.toString())
        _deviceHardware.postValue(Build.HARDWARE.toString())
        _deviceAndroidId.postValue(Build.ID.toString())
        _deviceScreenResolution.postValue(Build.DISPLAY.toString())
        _deviceBootloader.postValue(Build.BOOTLOADER.toString())
        _deviceUser.postValue(Build.USER.toString())
        _deviceHost.postValue(Build.HOST.toString())
    }
}