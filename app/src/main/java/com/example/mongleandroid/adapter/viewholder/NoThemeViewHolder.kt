package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.response.DataSentence
import com.example.mongleandroid.network.data.response.NoThemeSentence
import com.example.mongleandroid.network.data.response.ResponseNoThemeData
import com.example.mongleandroid.network.data.response.ResponseThemeDetailData

class NoThemeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val tv_theme_sentence = itemView.findViewById<TextView>(R.id.tv_theme_sentence)
    val tv_theme_curator = itemView.findViewById<TextView>(R.id.tv_theme_curator)
    val tv_like_num = itemView.findViewById<TextView>(R.id.tv_like_num)
    val tv_save_num = itemView.findViewById<TextView>(R.id.tv_save_num)

    fun bind(noThemeSentence: NoThemeSentence){
        tv_theme_sentence.text = noThemeSentence.sentence
        tv_theme_curator.text = noThemeSentence.author
        tv_like_num.text = noThemeSentence.publisher.toString()
        tv_save_num.text = noThemeSentence.timestamp.toString()

    }

}