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
//    val rdbtn_saved_thema = itemView.findViewById<RadioButton>(R.id.rdbtn_saved_thema)
//    val rdbtn_making_thema = itemView.findViewById<RadioButton>(R.id.rdbtn_making_thema)

    fun bind(libraryThemaData: LibraryThemaData) {
        tv_library_thema.text = libraryThemaData.tv_library_thema
        tv_thema_num_library.text = libraryThemaData.tv_thema_num_library
        tv_sentence_count_library_item.text = libraryThemaData.tv_sentence_count_library_item

//        rdbtn_saved_thema.setOnClickListener {
//            if (rdbtn_saved_thema.isChecked) {
//                rdbtn_saved_thema.setTextColor(Color.WHITE)
//            } else rdbtn_saved_thema.setTextColor(Color.LTGRAY)
//
//        }
//
//        rdbtn_making_thema.setOnClickListener {
//            if (rdbtn_making_thema.isChecked) {
//                rdbtn_making_thema.setTextColor(Color.LTGRAY)
//            } else rdbtn_making_thema.setTextColor(Color.WHITE)
//
//        }
    }
}