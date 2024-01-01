package com.practice.deviceinfo.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.practice.deviceinfo.ui.camera.CameraFragment
import com.practice.deviceinfo.ui.cpu.CPUFragment
import com.practice.deviceinfo.ui.dashboard.DashboardFragment
import com.practice.deviceinfo.ui.device.DeviceFragment
import com.practice.deviceinfo.ui.display.DisplayFragment
import com.practice.deviceinfo.ui.features.FeaturesFragment
import com.practice.deviceinfo.ui.network.NetworkFragment
import com.practice.deviceinfo.ui.os.OSFragment
import com.practice.deviceinfo.ui.sensors.SensorsFragment
import com.practice.deviceinfo.ui.settings.SettingsFragment
import com.practice.deviceinfo.ui.storage.StorageFragment
import com.practice.deviceinfo.ui.systemapps.SystemAppsFragment
import com.practice.deviceinfo.ui.testmydevice.TestMyDeviceFragment
import com.practice.deviceinfo.ui.userapps.UserAppsFragment

class ViewPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> DashboardFragment()
        1 -> CameraFragment()
        2 -> CPUFragment()
        3 -> DashboardFragment()
        4 -> DeviceFragment()
        5 -> DisplayFragment()
        6 -> FeaturesFragment()
        7 -> NetworkFragment()
        8 -> OSFragment()
        9 -> SensorsFragment()
        10 -> SettingsFragment()
        11 -> StorageFragment()
        12 -> SystemAppsFragment()
        13 -> TestMyDeviceFragment()
        14 -> UserAppsFragment()

        else -> DashboardFragment()
    }

    private companion object {
        const val NUM_PAGES = 15
    }
}