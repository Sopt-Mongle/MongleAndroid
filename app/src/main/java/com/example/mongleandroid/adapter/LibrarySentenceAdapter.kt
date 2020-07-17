package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.LibrarySentenceViewHolder
import com.example.mongleandroid.network.data.LibrarySentenceData
import com.example.mongleandroid.network.data.response.LibrarySentenceWrite

class LibrarySentenceAdapter(private val context: Context, var data_sen:List<LibrarySentenceWrite>) :
    RecyclerView.Adapter<LibrarySentenceViewHolder>() {
//    var data_sen = mutableListOf<LibrarySentenceData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibrarySentenceViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_library_sentence, parent, false)
        return LibrarySentenceViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return data_sen.size
    }

    override fun onBindViewHolder(holder: LibrarySentenceViewHolder, position: Int) {
        holder.bind(data_sen[position])
    }

}