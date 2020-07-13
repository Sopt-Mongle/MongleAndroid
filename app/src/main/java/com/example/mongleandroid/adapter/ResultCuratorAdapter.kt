package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.ResultCuratorViewHolder
import com.example.mongleandroid.network.data.response.ResponseResultCuratorData

class ResultCuratorAdapter(private val context : Context) : RecyclerView.Adapter<ResultCuratorViewHolder>() {
    var datas = mutableListOf<ResponseResultCuratorData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultCuratorViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_result_curator, parent, false)
        return ResultCuratorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: ResultCuratorViewHolder, position: Int) {
        holder.bind(datas[position])
    }
}