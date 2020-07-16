package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.response.ResponseTodaySentenceData

class TodaySentenceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tv_today_sentence = itemView.findViewById<TextView>(R.id.tv_today_sentence)

    fun bind(todaySentenceData: ResponseTodaySentenceData){
        tv_today_sentence.text = todaySentenceData.sentence
    }
}