package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.ResultThemeViewHolder
import com.example.mongleandroid.network.data.response.ResultTheme

class ResultThemeAdapter(private val context: Context) : RecyclerView.Adapter<ResultThemeViewHolder>() {
    var datas = mutableListOf<ResultTheme>()
    //var datas:List<ResultTheme>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultThemeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_result_theme, parent, false)
        return ResultThemeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: ResultThemeViewHolder, position: Int) {
        holder.bind(datas[position])
    }
}