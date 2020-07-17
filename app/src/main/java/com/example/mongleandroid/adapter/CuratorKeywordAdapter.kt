package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.CuratorKeywordViewHolder
import com.example.mongleandroid.adapter.viewholder.CuratorViewHolder
import com.example.mongleandroid.network.data.CuratorData
import com.example.mongleandroid.network.data.response.CuratorKeyword
import com.example.mongleandroid.network.data.response.ResponseCuratorKeywordData

class CuratorKeywordAdapter(private val context : Context, val datas: List<CuratorKeyword>) : RecyclerView.Adapter<CuratorKeywordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuratorKeywordViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_result_curator,parent,false)
        return CuratorKeywordViewHolder(
            view
        )

    }

    override fun getItemCount(): Int {
        return datas.size

    }

    override fun onBindViewHolder(holder: CuratorKeywordViewHolder, position: Int) {

        holder.bind(datas[position])

    }
}