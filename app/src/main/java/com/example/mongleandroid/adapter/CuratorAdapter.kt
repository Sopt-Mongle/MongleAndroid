package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.CuratorViewHolder
import com.example.mongleandroid.network.data.CuratorData

class CuratorAdapter(private val context : Context) : RecyclerView.Adapter<CuratorViewHolder>() {

    var datas = mutableListOf<CuratorData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuratorViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_result_curator,parent,false)
        return CuratorViewHolder(
            view
        )

    }

    override fun getItemCount(): Int {
        return datas.size

    }

    override fun onBindViewHolder(holder: CuratorViewHolder, position: Int) {

        holder.bind(datas[position])

    }
}