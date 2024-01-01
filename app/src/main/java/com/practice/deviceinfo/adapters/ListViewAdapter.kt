package com.practice.deviceinfo.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.practice.deviceinfo.databinding.ItemInfoBinding

class ListViewAdapter(private val items: List<Pair<String, String>>): BaseAdapter() {

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any = position

    override fun getItemId(position: Int): Long = position.toLong()

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val currentItem = items[position]
        val binding = ItemInfoBinding.inflate(LayoutInflater.from(parent?.context), parent, false)

        binding.infoTitle.text = currentItem.first
        binding.infoValue.text = currentItem.second

        return binding.root
    }
}