package com.example.mongleandroid.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.ItemDecoration
import com.example.mongleandroid.adapter.WritingSentenceBookSearchAdapter
import com.example.mongleandroid.network.data.response.BookData
import com.example.mongleandroid.network.data.response.ResponseWritingSentenceBookSearchData
import com.example.mongleandroid.network.data.response.ResponseWritingSentenceThemeSearchData
import kotlinx.android.synthetic.main.activity_writing_sentence_book_search.*
import kotlinx.android.synthetic.main.activity_writing_sentence_theme_search.*

class WritingSentenceBookSearchActivity : AppCompatActivity() {

    lateinit var writingSentenceBookSearchAdapter: WritingSentenceBookSearchAdapter
    val datas = mutableListOf<BookData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing_sentence_book_search)

        writingSentenceBookSearchAdapter = WritingSentenceBookSearchAdapter(this)
        activity_writing_sentence_book_search_rv_after.adapter = writingSentenceBookSearchAdapter
        activity_writing_sentence_book_search_rv_after.addItemDecoration(ItemDecoration())
        loadDatas()

        activity_writing_sentence_book_search_btn_out.setOnClickListener {

        }

//        activity_writing_sentence_book_search_rv_after.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
//            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
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


    }

    private fun loadDatas(){
        datas.apply {
            add(

                BookData(
                    authors = "해리",
                    publisher = "몽글1",
                    thumbnail = "dsf",
                    title = "해리포터",
                    isbn = "dsfa"
                )
            )
            add(

                BookData(
                    authors = "해리",
                    publisher = "몽글2",
                    thumbnail = "dsf",
                    title = "해리포터",
                    isbn = "dsfa"
                )
            )
            add(

                BookData(
                    authors = "해리",
                    publisher = "몽글3",
                    thumbnail = "dsf",
                    title = "해리포터",
                    isbn = "dsfa"
                )
            )
            add(

                BookData(
                    authors = "해리",
                    publisher = "몽글4",
                    thumbnail = "dsf",
                    title = "해리포터",
                    isbn = "dsfa"
                )
            )
            add(

                BookData(
                    authors = "해리",
                    publisher = "몽글5",
                    thumbnail = "dsf",
                    title = "해리포터",
                    isbn = "dsfa"
                )
            )
            writingSentenceBookSearchAdapter.datas = datas
            writingSentenceBookSearchAdapter.notifyDataSetChanged()
        }
    }
    //            val intent = Intent(thisActivity, LoginActivity::class.java)
////            intent.putExtra("id", et_join_id.text.toString())
////            intent.putExtra("pw", et_join_pw.text.toString())
////            setResult(1, intent)
////            finish()






}