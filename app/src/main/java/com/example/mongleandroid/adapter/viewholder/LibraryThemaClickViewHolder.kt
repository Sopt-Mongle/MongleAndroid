package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.response.LibraryThemeSave
import com.example.mongleandroid.network.data.response.LibraryThemeWrite

class LibraryThemaClickViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tv_library_thema = itemView.findViewById<TextView>(R.id.tv_library_thema)
    val tv_thema_num_library = itemView.findViewById<TextView>(R.id.tv_thema_num_library)
    val tv_sentence_count_library_item =
        itemView.findViewById<TextView>(R.id.tv_sentence_count_library_item)
//    val rdbtn_saved_thema = itemView.findViewById<RadioButton>(R.id.rdbtn_saved_thema)
//    val rdbtn_making_thema = itemView.findViewById<RadioButton>(R.id.rdbtn_making_thema)

    fun bind(libraryThemeWrite: LibraryThemeWrite) {
        tv_library_thema.text = libraryThemeWrite.theme
        tv_thema_num_library.text = libraryThemeWrite.saves.toString()
        tv_sentence_count_library_item.text = libraryThemeWrite.sentenceNum.toString()

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