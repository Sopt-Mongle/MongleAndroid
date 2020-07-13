package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.NowHotCuratorViewHolder
import com.example.mongleandroid.network.data.MainNowHotCuratorData

class MainNowHotCuratorAdapter (var datas: List<MainNowHotCuratorData>, val context: Context) : RecyclerView.Adapter<NowHotCuratorViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowHotCuratorViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_main_now_hot_curator,parent,false)
        return NowHotCuratorViewHolder(view)
    }

    override fun getItemCount() = datas.size

    override fun onBindViewHolder(holder: NowHotCuratorViewHolder, position: Int) {
        holder.bind(datas[position])
    }


}