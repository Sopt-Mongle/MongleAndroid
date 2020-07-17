package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.LibraryThemaClickViewHolder
import com.example.mongleandroid.adapter.viewholder.LibraryThemaViewHolder
import com.example.mongleandroid.network.data.response.LibraryThemeSave

class LibraryThemaClickAdapter(private val context: Context, var data_the_save : List<LibraryThemeSave>) :
    RecyclerView.Adapter<LibraryThemaClickViewHolder>() {
//    var data_the = mutableListOf<LibraryThemeWrite>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryThemaClickViewHolder {
        val view_click_thema = LayoutInflater.from(context).inflate(R.layout.item_library_thema, parent, false)
        return LibraryThemaClickViewHolder(view_click_thema)
    }

    override fun getItemCount(): Int {
        return data_the_save.size
    }

    override fun onBindViewHolder(holder: LibraryThemaClickViewHolder, position: Int) {
        holder.bind(data_the_save[position])
    }

}