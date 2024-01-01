package com.practice.deviceinfo.ui.device

import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.practice.deviceinfo.models.Device

class DeviceViewModel : ViewModel() {

    private val _device = MutableLiveData<Device>()
    val device: LiveData<Device>
        get() = _device

    fun getDeviceInfo() {
        _device.postValue(
            Device(
                manufacturer = Build.MANUFACTURER.toString(),
                brand = Build.BRAND.toString(),
                model = Build.MODEL.toString(),
                board = Build.BOARD.toString(),
                hardware = Build.HARDWARE.toString(),
                androidId = Build.ID.toString(),
                screenResolution = Build.DISPLAY.toString(),
                bootloader = Build.BOOTLOADER.toString(),
                user = Build.USER.toString(),
                host = Build.HOST.toString(),
            )
        )
    }
}