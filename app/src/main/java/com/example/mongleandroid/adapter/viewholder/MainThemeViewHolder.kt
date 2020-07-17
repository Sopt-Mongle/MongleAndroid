package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.MainThemeData
import com.example.mongleandroid.network.data.response.DataSentence

class MainThemeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val tv_theme_sentence = itemView.findViewById<TextView>(R.id.tv_theme_sentence)
    val tv_theme_curator = itemView.findViewById<TextView>(R.id.tv_theme_curator)
    val tv_like_num = itemView.findViewById<TextView>(R.id.tv_like_num)
    val tv_save_num = itemView.findViewById<TextView>(R.id.tv_save_num)

    fun bind(dataSentence: DataSentence){
        tv_theme_sentence.text = dataSentence.sentence
        tv_theme_curator.text = dataSentence.writer
        tv_like_num.text = dataSentence.likes.toString()
        tv_save_num.text = dataSentence.saves.toString()

    }

}