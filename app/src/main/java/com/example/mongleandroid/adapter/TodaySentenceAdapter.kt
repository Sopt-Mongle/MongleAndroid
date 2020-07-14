package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.TodaySentenceViewHolder
import com.example.mongleandroid.network.data.TodaySentenceData

class TodaySentenceAdapter(var datas: List<TodaySentenceData>, val context: Context) : RecyclerView.Adapter<TodaySentenceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodaySentenceViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_today_sentence, parent, false)
        return TodaySentenceViewHolder(view)
    }

    override fun getItemCount() = datas.size

    override fun onBindViewHolder(holder: TodaySentenceViewHolder, position: Int) {
        holder.bind(datas[position])
    }

}