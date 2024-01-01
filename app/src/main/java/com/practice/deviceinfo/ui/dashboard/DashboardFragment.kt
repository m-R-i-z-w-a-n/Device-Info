package com.practice.deviceinfo.ui.dashboard

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
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
//    private val cpuViewModel by viewModels<CPUViewModel>()

    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        deviceViewModel.getDeviceInfo()
        _binding = DataBindingUtil.bind(view)
        binding.deviceViewModel = deviceViewModel
        binding.lifecycleOwner = this

        initViews()

    }

    private fun initViews() {
        binding.testMyDeviceCard.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, TestMyDeviceFragment())
                commit()
            }

            Toast.makeText(requireContext(), "Clicking test summary", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}