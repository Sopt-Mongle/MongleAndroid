package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.LibraryThemaData

class LibraryThemaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tv_library_thema = itemView.findViewById<TextView>(R.id.tv_library_thema)
    val tv_thema_num_library = itemView.findViewById<TextView>(R.id.tv_thema_num_library)
    val tv_sentence_count_library_item =
        itemView.findViewById<TextView>(R.id.tv_sentence_count_library_item)

    fun bind(libraryThemaData: LibraryThemaData) {
        tv_library_thema.text = libraryThemaData.tv_library_thema
        tv_thema_num_library.text = libraryThemaData.tv_thema_num_library
        tv_sentence_count_library_item.text = libraryThemaData.tv_sentence_count_library_item
    }
}