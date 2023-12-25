package com.practice.deviceinfo.ui.device

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.practice.deviceinfo.R
import com.practice.deviceinfo.databinding.FragmentDeviceBinding

class DeviceFragment : Fragment(R.layout.fragment_device) {

    private var _binding: FragmentDeviceBinding? = null

    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDeviceBinding. bind(view)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}