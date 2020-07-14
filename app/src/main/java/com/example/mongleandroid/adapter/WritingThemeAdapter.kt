package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.WritingThemeViewHolder
import com.example.mongleandroid.network.data.request.RequestWritingThemeData
import com.example.mongleandroid.network.data.response.ResponseWritingThemeData

class WritingThemeAdapter(private val context : Context) : RecyclerView.Adapter<WritingThemeViewHolder>()  {

    var datas = mutableListOf<Int>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WritingThemeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_writng_theme,parent,false )
        return WritingThemeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: WritingThemeViewHolder, position: Int) {
        holder.bind(datas[position])
    }


}
