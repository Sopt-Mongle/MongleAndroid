package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mongleandroid.R
import com.example.mongleandroid.network.data.LibraryCuratorData
import com.example.mongleandroid.network.data.response.LibraryCurator
import com.example.mongleandroid.network.data.response.ResponseLibraryCuratorData

class LibraryCuratorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val library_curator_img_profile =
        itemView.findViewById<ImageView>(R.id.library_curator_img_profile)
    val tv_library_curator_name = itemView.findViewById<TextView>(R.id.tv_library_curator_name)
    val tv_library_curator_subcount =
        itemView.findViewById<TextView>(R.id.tv_library_curator_subcount)
    val tv_library_curator_keyword =
        itemView.findViewById<TextView>(R.id.tv_library_curator_keyword)
    val library_curator_btn_subscribe_item =
        itemView.findViewById<CheckBox>(R.id.library_curator_btn_subscribe_item)

    fun bind(libraryCurator: LibraryCurator) {
        Glide.with(itemView).load(libraryCurator.img)
            .into(library_curator_img_profile)
        tv_library_curator_name.text = libraryCurator.name
        tv_library_curator_subcount.text = libraryCurator.subscribe.toString()
        tv_library_curator_keyword.text = libraryCurator.keyword
        library_curator_btn_subscribe_item.setOnClickListener {
            if (library_curator_btn_subscribe_item.isChecked) {
                library_curator_btn_subscribe_item.setText("구독중")
            } else library_curator_btn_subscribe_item.setText("구독")

        }
    }
}