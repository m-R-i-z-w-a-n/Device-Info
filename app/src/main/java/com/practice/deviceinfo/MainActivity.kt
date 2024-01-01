package com.practice.deviceinfo

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.practice.deviceinfo.adapters.ViewPagerAdapter
import com.practice.deviceinfo.databinding.ActivityMainBinding
import com.practice.deviceinfo.ui.battery.BatteryFragment
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


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private val drawer: DrawerLayout by lazy { binding.drawer }
    private val navView: NavigationView by lazy { binding.navView }

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addFragment(DashboardFragment())

        initViews()
    }

    private fun initViews() {
        initDrawerView()

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_dashboard -> replaceFragment(DashboardFragment())

                R.id.item_device -> replaceFragment(DeviceFragment())

                R.id.item_os -> replaceFragment(OSFragment())

                R.id.item_cpu -> replaceFragment(CPUFragment())

                R.id.item_battery -> replaceFragment(BatteryFragment())

                R.id.item_memory -> replaceFragment(StorageFragment())

                R.id.item_sensor -> replaceFragment(SensorsFragment())

                R.id.item_network -> replaceFragment(NetworkFragment())

                R.id.item_display -> replaceFragment(DisplayFragment())

                R.id.item_camera -> replaceFragment(CameraFragment())

                R.id.item_features -> replaceFragment(FeaturesFragment())

                R.id.item_user_apps -> replaceFragment(UserAppsFragment())

                R.id.item_system_apps -> replaceFragment(SystemAppsFragment())

                R.id.item_test -> replaceFragment(TestMyDeviceFragment())

                R.id.item_settings -> replaceFragment(SettingsFragment())
            }

            drawer.closeDrawer(GravityCompat.START)

            true
        }
        initViewPager()
    }

    private fun initViewPager() {
        viewPager = findViewById(R.id.view_pager)
        tabLayout = binding.appBarMain.tabLayout

        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
            tab.text = "Tab ${pos + 1}"
        }.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

        supportActionBar?.elevation = 0F
    }


    private fun initDrawerView() {
        setSupportActionBar(binding.appBarMain.toolbar)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawer, R.string.app_name, R.string.app_name).apply {
                drawer.addDrawerListener(this)
                syncState()
            }

    }

    private fun addFragment(fragment: Fragment) {
        val fragmentContainer = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (fragmentContainer == null) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.fragment_container, fragment)
                commit()
            }
            navView.setCheckedItem(R.id.item_dashboard)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true

        return super.onOptionsItemSelected(item)
    }
}