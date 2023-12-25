package com.practice.deviceinfo.ui.dashboard

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.practice.deviceinfo.R
import com.practice.deviceinfo.databinding.FragmentDashboardBinding
import com.practice.deviceinfo.ui.cpu.CPUViewModel
import com.practice.deviceinfo.ui.device.DeviceViewModel
import com.practice.deviceinfo.ui.testmydevice.TestMyDeviceFragment

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private var _binding: FragmentDashboardBinding? = null

    private val deviceViewModel by viewModels<DeviceViewModel>()
    private val cpuViewModel by viewModels<CPUViewModel>()

    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDashboardBinding.bind(view)
        initViews()

    }

    private fun initViews() {
        deviceViewModel.getDeviceInfo()

        deviceViewModel.deviceManufacturer.observe(requireActivity()) {
            binding.dashDeviceName.text = it
        }
        deviceViewModel.deviceBrand.observe(requireActivity()) {
            binding.dashModelName.text = it
        }

        binding.testMyDeviceLinearLayout.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, TestMyDeviceFragment())
                commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}