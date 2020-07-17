package com.example.mongleandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.viewholder.LibraryCuratorViewHolder
import com.example.mongleandroid.network.data.LibraryCuratorData
import com.example.mongleandroid.network.data.response.LibraryCurator
import com.example.mongleandroid.network.data.response.ResponseLibraryCuratorData

class LibraryCuratorAdapter(private val context: Context, var data_cu : List<LibraryCurator>) :
    RecyclerView.Adapter<LibraryCuratorViewHolder>() {
//    var data_cu = mutableListOf<LibraryCurator>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryCuratorViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_library_curator, parent, false)
        return LibraryCuratorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data_cu.size
    }

    override fun onBindViewHolder(holder: LibraryCuratorViewHolder, position: Int) {
        holder.bind(data_cu[position])
    }

}