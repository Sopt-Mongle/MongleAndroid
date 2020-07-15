package com.example.mongleandroid.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.CuratorInfoThemaAdapter
import com.example.mongleandroid.network.data.CuratorInfoThemaData

class CuratorInfoThemaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tv_library_thema_cu_info = itemView.findViewById<TextView>(R.id.tv_library_thema_cu_info)
    val tv_thema_num_library_cu_info = itemView.findViewById<TextView>(R.id.tv_thema_num_library_cu_info)
    val tv_sentence_count_library_item_cu_info =
        itemView.findViewById<TextView>(R.id.tv_sentence_count_library_item_cu_info)
//    val rdbtn_saved_thema = itemView.findViewById<RadioButton>(R.id.rdbtn_saved_thema)
//    val rdbtn_making_thema = itemView.findViewById<RadioButton>(R.id.rdbtn_making_thema)

    fun bind(curatorInfoThemaData: CuratorInfoThemaData) {
        tv_library_thema_cu_info.text = curatorInfoThemaData.thema_cu_info
        tv_thema_num_library_cu_info.text = curatorInfoThemaData.thema_num_library_cu_info
        tv_sentence_count_library_item_cu_info.text = curatorInfoThemaData.sentence_count_library_item_cu_info

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