package com.practice.deviceinfo.ui.testmydevice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.practice.deviceinfo.R
import com.practice.deviceinfo.databinding.FragmentTestMyDeviceBinding

class TestMyDeviceFragment : Fragment(R.layout.fragment_test_my_device) {

    private var _binding: FragmentTestMyDeviceBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTestMyDeviceBinding.bind(view)


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}