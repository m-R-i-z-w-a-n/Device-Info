package com.practice.deviceinfo.ui.device

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.practice.deviceinfo.adapters.ListViewAdapter
import com.practice.deviceinfo.R
import com.practice.deviceinfo.databinding.FragmentDeviceBinding

class DeviceFragment : Fragment(R.layout.fragment_device) {

    private var _binding: FragmentDeviceBinding? = null
    private val binding get() = _binding!!

    private val deviceViewModel by viewModels<DeviceViewModel>()

    private lateinit var listAdapter: ListViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDeviceBinding.bind(view)

        initViews()
    }

    private fun initViews() {
        initListView()
    }

    private fun initListView() {
        val items = mutableListOf<Pair<String, String>>()
        deviceViewModel.also { it.getDeviceInfo() }.device.observe(requireActivity()) {
            items.apply {
                add(
                    Pair("Manufacturer", it.manufacturer)
                )
                add(
                    Pair("Brand", it.brand)
                )
                add(
                    Pair("Model", it.model)
                )
                add(
                    Pair("Board", it.board)
                )
                add(
                    Pair("Hardware", it.hardware)
                )
                add(
                    Pair("Andriod ID", it.androidId)
                )
                add(
                    Pair("Screen Resolution", getScreenResolution())
                )
                add(
                    Pair("Bootloader", it.bootloader)
                )
                add(
                    Pair("User", it.user)
                )
                add(
                    Pair("Host", it.host)
                )
            }

            listAdapter.notifyDataSetChanged()
        }

        binding.deviceInfoListView.apply {
            listAdapter = ListViewAdapter(items)
            adapter = listAdapter
        }
    }

    private fun getScreenResolution(): String {
        val displayMetrics = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(displayMetrics)

        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels

        return "$height * $width Pixels"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}