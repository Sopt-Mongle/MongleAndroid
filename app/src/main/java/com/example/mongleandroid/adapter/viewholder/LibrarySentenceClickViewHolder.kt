package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.LibrarySentenceData

class LibrarySentenceClickViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tv_library_sentence_themename =
        itemView.findViewById<TextView>(R.id.tv_library_sentence_themename)
    val tv_library_sentence_sentence =
        itemView.findViewById<TextView>(R.id.tv_library_sentence_sentence)
    val tv_item_library_sentence_username =
        itemView.findViewById<TextView>(R.id.tv_item_library_sentence_username)

    fun bind(librarySentenceData: LibrarySentenceData) {
        tv_library_sentence_themename.text = librarySentenceData.tv_library_sentence_themename
        tv_library_sentence_sentence.text = librarySentenceData.tv_library_sentence_sentence
        tv_item_library_sentence_username.text =
            librarySentenceData.tv_item_library_sentence_username
    }
}