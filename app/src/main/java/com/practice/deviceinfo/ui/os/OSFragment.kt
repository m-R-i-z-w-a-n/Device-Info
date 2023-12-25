package com.practice.deviceinfo.ui.os

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.practice.deviceinfo.R
import com.practice.deviceinfo.databinding.FragmentOsBinding

class OSFragment : Fragment(R.layout.fragment_os) {

    private var _binding: FragmentOsBinding? = null

    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOsBinding.bind(view)


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}