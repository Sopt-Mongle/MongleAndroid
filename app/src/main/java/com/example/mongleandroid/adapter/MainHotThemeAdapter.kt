package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.HotThemeViewHolder
import com.example.mongleandroid.network.data.MainHotThemeData

class MainHotThemeAdapter(var datas: List<MainHotThemeData>, val context: Context) : RecyclerView.Adapter<HotThemeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotThemeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_main_hot_theme, parent, false)
        return HotThemeViewHolder(view)
    }

    override fun getItemCount() = datas.size

    override fun onBindViewHolder(holder: HotThemeViewHolder, position: Int) {
        holder.bind(datas[position])
    }

}