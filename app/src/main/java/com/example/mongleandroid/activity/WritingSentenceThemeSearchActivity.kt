package com.example.mongleandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.ItemDecoration
import com.example.mongleandroid.adapter.WritingSentenceThemeSearchAdapter
import com.example.mongleandroid.network.data.response.ResponseWritingSentenceThemeSearchData
import kotlinx.android.synthetic.main.activity_writing_sentence_theme_search.*
import kotlinx.android.synthetic.main.item_theme_search.*

class WritingSentenceThemeSearchActivity : AppCompatActivity() {

    lateinit var writingSentenceThemeSearchAdapter : WritingSentenceThemeSearchAdapter
    val datas = mutableListOf<ResponseWritingSentenceThemeSearchData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing_sentence_theme_search)


        //val myLayoutManager = GridLayoutManager(this, 2, RecyclerView.HORIZONTAL, false)
        val myLayoutManager = GridLayoutManager(this, 2)

        activity_writing_sentence_theme_search_rv_after.layoutManager = myLayoutManager

        writingSentenceThemeSearchAdapter = WritingSentenceThemeSearchAdapter(this)
        activity_writing_sentence_theme_search_rv_after.adapter = writingSentenceThemeSearchAdapter
        activity_writing_sentence_theme_search_rv_after.addItemDecoration(ItemDecoration())
        loadDatas()

    }

    private fun loadDatas(){
        datas.apply {
            add(

                ResponseWritingSentenceThemeSearchData(
                    theme = "브랜딩이 어려울 때 영감을 주는 문장1"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "번아웃을 극복하고\n" +
                            "싶을 때 봐야하는\n" +
                            "문장2"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "번아웃을 극복하고\n" +
                            "싶을 때 봐야하는\n" +
                            "문장3"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "브랜딩이 어려울 때\n" +
                            "영감을 주는 문장4"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "브랜딩이 어려울 때\n" +
                            "영감을 주는 문장5"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "브랜딩이 어려울 때\n" +
                            "영감을 주는 문장6"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "브랜딩이 어려울 때\n" +
                            "영감을 주는 문장7"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "번아웃을 극복하고\n" +
                            "싶을 때 봐야하는\n" +
                            "문장3"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "브랜딩이 어려울 때\n" +
                            "영감을 주는 문장4"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "브랜딩이 어려울 때\n" +
                            "영감을 주는 문장5"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "브랜딩이 어려울 때\n" +
                            "영감을 주는 문장6"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "브랜딩이 어려울 때\n" +
                            "영감을 주는 문장7"
                )
            )
            add(

                ResponseWritingSentenceThemeSearchData(
                    theme = "브랜딩이 어려울 때 영감을 주는 문장1"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "번아웃을 극복하고\n" +
                            "싶을 때 봐야하는\n" +
                            "문장2"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "번아웃을 극복하고\n" +
                            "싶을 때 봐야하는\n" +
                            "문장3"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "브랜딩이 어려울 때\n" +
                            "영감을 주는 문장4"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "브랜딩이 어려울 때\n" +
                            "영감을 주는 문장5"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "브랜딩이 어려울 때\n" +
                            "영감을 주는 문장6"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "브랜딩이 어려울 때\n" +
                            "영감을 주는 문장7"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "번아웃을 극복하고\n" +
                            "싶을 때 봐야하는\n" +
                            "문장3"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "브랜딩이 어려울 때\n" +
                            "영감을 주는 문장4"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "브랜딩이 어려울 때\n" +
                            "영감을 주는 문장5"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "브랜딩이 어려울 때\n" +
                            "영감을 주는 문장6"
                )
            )
            add(
                ResponseWritingSentenceThemeSearchData(
                    theme = "브랜딩이 어려울 때\n" +
                            "영감을 주는 문장7"
                )
            )
            writingSentenceThemeSearchAdapter.datas = datas
            writingSentenceThemeSearchAdapter.notifyDataSetChanged()
        }

    }
}