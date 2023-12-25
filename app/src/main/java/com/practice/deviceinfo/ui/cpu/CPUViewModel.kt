package com.practice.deviceinfo.ui.cpu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class CPUViewModel: ViewModel() {

    private val _cpuUsage = MutableLiveData<Int>()
    val cpuUsage: LiveData<Int>
        get() = _cpuUsage


}