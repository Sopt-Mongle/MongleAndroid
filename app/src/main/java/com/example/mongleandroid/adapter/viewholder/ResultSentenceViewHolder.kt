package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.ResultSentenceData

class ResultSentenceViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    val result_sentence_tv_themename = itemView.findViewById<TextView>(R.id.result_sentence_tv_themename)
    val result_sentence_tv_context = itemView.findViewById<TextView>(R.id.result_sentence_tv_context)

    fun bind(resultSentenceData: ResultSentenceData){
        result_sentence_tv_themename.text = resultSentenceData.result_sentence_tv_themename
        result_sentence_tv_context.text = resultSentenceData.result_sentence_tv_context
    }
}

