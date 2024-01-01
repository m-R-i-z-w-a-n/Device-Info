package com.practice.deviceinfo.ui.os

import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.practice.deviceinfo.models.OS
import java.text.SimpleDateFormat
import java.util.Date

class OSViewModel : ViewModel() {

    private val _os = MutableLiveData<OS>()
    val os: LiveData<OS>
        get() = _os

    fun getOSInfo() {
        _os.postValue(
            OS(
                version = Build.VERSION.RELEASE.toString(),
                versionName = "Android ${Build.VERSION.RELEASE}",
                apiLevel = Build.VERSION.SDK_INT.toString(),
                buildId = Build.ID.toString(),
                buildTime = getDateFromMS(Build.TIME),
                fingerprint = Build.FINGERPRINT.toString()
            )
        )
    }

    /**
     * Converts milliseconds to Date
     *
     * @param ms MilliSeconds to be converted into date
     * @return Converted date string
     */
    private fun getDateFromMS(ms: Long): String {
        return Date(ms).toString()
    }
}
