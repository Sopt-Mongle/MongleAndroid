package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.CuratorInfoThemaViewHolder
import com.example.mongleandroid.adapter.viewholder.LibraryThemaViewHolder
import com.example.mongleandroid.network.data.CuratorInfoThemaData

class CuratorInfoThemaAdapter(private val context: Context) :
    RecyclerView.Adapter<CuratorInfoThemaViewHolder>() {
    var data_the_cu_info = mutableListOf<CuratorInfoThemaData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuratorInfoThemaViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_cu_info_thema, parent, false)
        return CuratorInfoThemaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data_the_cu_info.size
    }

    override fun onBindViewHolder(holder: CuratorInfoThemaViewHolder, position: Int) {
        holder.bind(data_the_cu_info[position])
    }

}