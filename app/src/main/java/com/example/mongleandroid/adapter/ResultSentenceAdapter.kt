package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.ResultSentenceViewHolder
import com.example.mongleandroid.network.data.response.ResultSentence

class ResultSentenceAdapter(private val context : Context, var datas: List<ResultSentence>) : RecyclerView.Adapter<ResultSentenceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultSentenceViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_result_sentence, parent, false)
        return ResultSentenceViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: ResultSentenceViewHolder, position: Int) {
        holder.bind(datas[position])
    }
}