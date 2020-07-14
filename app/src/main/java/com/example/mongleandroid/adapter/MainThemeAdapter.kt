package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.MainThemeViewHolder
import com.example.mongleandroid.network.data.MainThemeData

class MainThemeAdapter (var datas: List<MainThemeData>, val context: Context) : RecyclerView.Adapter<MainThemeViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainThemeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_activity_theme, parent, false)
        return MainThemeViewHolder(view)
    }

    override fun getItemCount() = datas.size

    override fun onBindViewHolder(holder: MainThemeViewHolder, position: Int) {
        holder.bind(datas[position])
    }

}