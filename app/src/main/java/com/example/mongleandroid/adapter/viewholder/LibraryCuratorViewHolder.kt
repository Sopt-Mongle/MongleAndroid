package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.LibraryCuratorData

class LibraryCuratorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val library_curator_img_profile =
        itemView.findViewById<ImageView>(R.id.library_curator_img_profile)
    val tv_library_curator_name = itemView.findViewById<TextView>(R.id.tv_library_curator_name)
    val tv_library_curator_subcount =
        itemView.findViewById<TextView>(R.id.tv_library_curator_subcount)
    val tv_library_curator_keyword =
        itemView.findViewById<TextView>(R.id.tv_library_curator_keyword)

    fun bind(libraryCuratorData: LibraryCuratorData) {
        Glide.with(itemView).load(libraryCuratorData.library_curator_img_profile)
            .into(library_curator_img_profile)
        tv_library_curator_name.text = libraryCuratorData.tv_library_curator_name
        tv_library_curator_subcount.text = libraryCuratorData.tv_library_curator_subcount
        tv_library_curator_keyword.text = libraryCuratorData.tv_library_curator_keyword
    }
}