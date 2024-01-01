package com.practice.deviceinfo.ui.os

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.practice.deviceinfo.adapters.ListViewAdapter
import com.practice.deviceinfo.R
import com.practice.deviceinfo.databinding.FragmentOsBinding

class OSFragment : Fragment(R.layout.fragment_os) {

    private var _binding: FragmentOsBinding? = null

    private val binding get() = _binding!!

    private lateinit var listAdapter: ListViewAdapter

    private val viewModel by viewModels<OSViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOsBinding.bind(view)
        initListView()

    }

    private fun initListView() {
        val items = mutableListOf<Pair<String, String>>()
        viewModel.also { it.getOSInfo() }.os.observe(requireActivity()) {
            items.apply {
                add(
                    Pair("Version", it.version)
                )
                add(
                    Pair("Version Name", it.versionName)
                )
                add(
                    Pair("API Level", it.apiLevel)
                )
                add(
                    Pair("Build ID", it.buildId)
                )
                add(
                    Pair("Build Time", it.buildTime)
                )
                add(
                    Pair("Fingerprint", it.fingerprint)
                )
            }

            listAdapter.notifyDataSetChanged()
        }

        binding.osInfoListView.apply {
            listAdapter = ListViewAdapter(items)
            adapter = listAdapter
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}