package com.example.mongleandroid.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.ItemDecoration
import com.example.mongleandroid.adapter.WritingSentenceBookSearchAdapter
import com.example.mongleandroid.adapter.WritingThemeAdapter
import com.example.mongleandroid.network.data.request.RequestWritingThemeData
import kotlinx.android.synthetic.main.activity_writing_sentence_book_search.*
import kotlinx.android.synthetic.main.activity_writing_theme.*
import kotlinx.android.synthetic.main.item_writng_theme.*
import kotlin.properties.Delegates

class WritingThemeActivity : AppCompatActivity() {

    lateinit var writingThemeAdapter: WritingThemeAdapter
    var datas: MutableList<Int> = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing_theme)

        writingThemeAdapter = WritingThemeAdapter(this)
        activity_writing_theme_rv.adapter = writingThemeAdapter
        //activity_writing_theme_rv.addItemDecoration(ItemDecoration())
        loadDatas()
    }
    private fun loadDatas(){
        datas.apply {
            add(
                R.drawable.maketheme_img_theme_1
            )
            add(
                R.drawable.maketheme_img_theme_2
            )
//            add(
//                R.drawable.maketheme_img_theme_3
//            )
//            add(
//                R.drawable.maketheme_img_theme_4
//            )
//            add(
//                R.drawable.maketheme_img_theme_5
//            )
//            add(
//                R.drawable.maketheme_img_theme_6
//            )
//            add(
//                R.drawable.maketheme_img_theme_7
//            )
//            add(
//                R.drawable.maketheme_img_theme_8
//            )
//            add(
//                R.drawable.maketheme_img_theme_9
//            )
//            add(
//                R.drawable.maketheme_img_theme_10
//            )


            writingThemeAdapter.datas = datas
            writingThemeAdapter.notifyDataSetChanged()

        }



    }

}


