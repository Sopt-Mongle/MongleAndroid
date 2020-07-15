package com.example.mongleandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.ItemDecoration
import com.example.mongleandroid.adapter.WritingSentenceThemeSearchAdapter
import com.example.mongleandroid.goNextPage
import com.example.mongleandroid.network.data.response.ResponseWritingSentenceThemeSearchData
import com.example.mongleandroid.network.data.response.ThemeData
import com.example.mongleandroid.showKeyboard
import com.example.mongleandroid.unshowKeyboard
import kotlinx.android.synthetic.main.activity_writing_sentence_book_search.*
import kotlinx.android.synthetic.main.activity_writing_sentence_theme_search.*
import kotlinx.android.synthetic.main.item_theme_search.*

class WritingSentenceThemeSearchActivity : AppCompatActivity() {

    lateinit var writingSentenceThemeSearchAdapter : WritingSentenceThemeSearchAdapter
    val datas = mutableListOf<ThemeData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing_sentence_theme_search)

        //키보드는 숨기
        activity_writing_sentence_theme_search_v_title.unshowKeyboard()


        val myLayoutManager = GridLayoutManager(this, 2)
        activity_writing_sentence_theme_search_rv_after.layoutManager = myLayoutManager
        writingSentenceThemeSearchAdapter = WritingSentenceThemeSearchAdapter(this)
        activity_writing_sentence_theme_search_rv_after.adapter = writingSentenceThemeSearchAdapter
        activity_writing_sentence_theme_search_rv_after.addItemDecoration(ItemDecoration())
        loadDatas()


        //뒤로가기 버튼
        activity_writing_sentence_theme_search_btn_out.setOnClickListener {
            finish()
        }
        //등록하기 버튼
        activity_writing_sentence_btn_next.setOnClickListener {


        }

        //검색할 때 (검색 눌렀을 때)
        activity_writing_sentence_theme_search_v_title.setOnClickListener{
            activity_writing_sentence_theme_search_bottombar.visibility = View.GONE
            activity_writing_sentence_theme_search_rv_after.visibility = View.GONE
            //포커스는 검색창기에
            activity_writing_sentence_theme_search_v_title.requestFocus()
            //키보드 보이기
            activity_writing_sentence_theme_search_v_title.showKeyboard()
        }


        //검색 버튼
        activity_writing_sentence_theme_search_btn_search.setOnClickListener {
            //키보드는 숨기
            activity_writing_sentence_theme_search_v_title.unshowKeyboard()
            activity_writing_sentence_theme_search_bottombar.visibility = View.VISIBLE
            activity_writing_sentence_theme_search_rv_after.visibility = View.VISIBLE
            loadDatas()

        }


        //if 서버 통신 성공
        //        activity_writing_sentence_book_search_rv_after.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
//            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {


        //아이템 터치 했을 때, 동작
//            val intent = Intent(this@WritingSentenceBookSearchActivity, WritingSentenceActivity::class.java)
//            intent.putExtra("title", item_search_book_tv_title.text.toString())
//            intent.putExtra("author", item_search_book_tv_author.text.toString())
//            intent.putExtra("publisher", item_search_book_tv_publisher.text.toString())
//            setResult(1, intent)
//            finish()
//
//                val child = rv.findChildViewUnder(e.x, e.y)
//                val position = rv.getChildAdapterPosition(child!!)
//
//                return false
//
//            }
//
//            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
//
//
//            }
//
//            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
//
//            }
//
//        })
//
//            //if 서버 통신 성공 && 결과 없음
//            goNextPage(activity_writing_sentence_book_search_before, activity_writing_sentence_book_search_after2)
//
//            //if 서버 통신 실패
//            goNextPage(activity_writing_sentence_book_search_before, activity_writing_sentence_book_search_after2)


        //rv 동작

    }

    private fun loadDatas(){
        datas.apply {
            add(

                ThemeData(
                    theme = "브랜딩이 어려울 때 영감을 주는 문장1",
                    themeImg = 1

                )
            )
            add(

                ThemeData(
                    theme = "브랜딩이 어려울 때 영감을 주는 문장1",
                    themeImg = 2

                    )
            )
            add(

                ThemeData(
                    theme = "브랜딩이 어려울 때 영감을 주는 문장1",
                    themeImg = 1

                    )
            )
            add(

                ThemeData(
                    theme = "브랜딩이 어려울 때 영감을 주는 문장1",
                    themeImg = 1

                    )
            )
            add(

                ThemeData(
                    theme = "브랜딩이 어려울 때 영감을 주는 문장1",
                    themeImg = 2

                )
            )
            writingSentenceThemeSearchAdapter.datas = datas
            writingSentenceThemeSearchAdapter.notifyDataSetChanged()
        }

    }
}