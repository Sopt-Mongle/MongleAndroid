package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.LibraryThemaViewHolder
import com.example.mongleandroid.network.data.response.LibraryThemeSave
import com.example.mongleandroid.network.data.response.LibraryThemeWrite

class LibraryThemaAdapter(private val context: Context, var data_the_write : List<LibraryThemeSave>) :
    RecyclerView.Adapter<LibraryThemaViewHolder>() {
//    var data_the = mutableListOf<LibraryThemeWrite>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryThemaViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_library_thema, parent, false)
        return LibraryThemaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data_the_write.size
    }

    override fun onBindViewHolder(holder: LibraryThemaViewHolder, position: Int) {
        holder.bind(data_the_write[position])
    }

}