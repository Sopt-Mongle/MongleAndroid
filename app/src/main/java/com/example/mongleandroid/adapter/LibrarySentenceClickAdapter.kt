package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.LibrarySentenceClickViewHolder
import com.example.mongleandroid.network.data.response.LibrarySentenceSave

class LibrarySentenceClickAdapter(private val context: Context, var data_sen_click: List<LibrarySentenceSave>) :
    RecyclerView.Adapter<LibrarySentenceClickViewHolder>() {
//    var data_sen_click = mutableListOf<LibrarySentenceData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibrarySentenceClickViewHolder {
        val view_click_sen =
            LayoutInflater.from(context).inflate(R.layout.item_library_sentence_click, parent, false)
        return LibrarySentenceClickViewHolder(
            view_click_sen
        )
    }

    override fun getItemCount(): Int {
        return data_sen_click.size
    }


    override fun onBindViewHolder(holder: LibrarySentenceClickViewHolder, position: Int) {
        holder.bind(data_sen_click[position])
    }

}