package com.practice.deviceinfo.ui.battery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.practice.deviceinfo.R
import com.practice.deviceinfo.databinding.FragmentBatteryBinding

class BatteryFragment : Fragment(R.layout.fragment_battery) {
    private var _binding: FragmentBatteryBinding? = null

    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBatteryBinding.bind(view)


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}