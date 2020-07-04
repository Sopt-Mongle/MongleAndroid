package com.example.mongleandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CuratorAdapter(private val context : Context) : RecyclerView.Adapter<CuratorViewHolder>() {

    var datas = mutableListOf<CuratorData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuratorViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_curator,parent,false)
        return CuratorViewHolder(view)

    }

    override fun getItemCount(): Int {

        return datas.size

    }

    override fun onBindViewHolder(holder: CuratorViewHolder, position: Int) {

        holder.bind(datas[position])

    }
}