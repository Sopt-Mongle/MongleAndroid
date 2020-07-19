package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.response.ResponseTodaySentenceData
import com.example.mongleandroid.network.data.response.TodaySentence

class TodaySentenceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tv_today_sentence = itemView.findViewById<TextView>(R.id.tv_today_sentence)
    val tv_today_sentence_title = itemView.findViewById<TextView>(R.id.tv_today_sentence_title)


    fun bind(todaySentence: TodaySentence){
        tv_today_sentence.text = todaySentence.sentence
        tv_today_sentence_title.text = todaySentence.title
    }
}