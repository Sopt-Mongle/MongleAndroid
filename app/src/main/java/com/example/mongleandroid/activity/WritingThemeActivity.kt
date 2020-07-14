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
    val datas: MutableList<Int> = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing_theme)

        writingThemeAdapter = WritingThemeAdapter(this)
        activity_writing_theme_rv.adapter = writingThemeAdapter
        //rv_home.addItemDecoration(ItemDecoration())
        loadDatas()
    }
    private fun loadDatas(){
        datas.apply {
            add(
                1
            )
            add(
                2
            )
//            add(
//                3
//            )
//            add(
//                4
//            )
//            add(
//                5
//            )
//            add(
//                6
//            )
//            add(
//                7
//            )
//            add(
//                8
//            )
//            add(
//                9
//            )
//            add(
//                10
//            )
            

            writingThemeAdapter.datas = datas
            writingThemeAdapter.notifyDataSetChanged()

        }



    }

}


