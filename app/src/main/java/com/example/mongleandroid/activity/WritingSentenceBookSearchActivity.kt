package com.example.mongleandroid.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.*
import com.example.mongleandroid.adapter.ItemDecoration
import com.example.mongleandroid.adapter.WritingSentenceBookSearchAdapter
import com.example.mongleandroid.network.RequestToServer
import com.example.mongleandroid.network.data.request.RequestWritingSentenceBookSearchData
import com.example.mongleandroid.network.data.response.BookData
import com.example.mongleandroid.network.data.response.ResponseWritingSentenceBookSearchData
import com.example.mongleandroid.network.data.response.ResponseWritingSentenceThemeSearchData
import kotlinx.android.synthetic.main.activity_writing_sentence.*
import kotlinx.android.synthetic.main.activity_writing_sentence_book_search.*
import kotlinx.android.synthetic.main.activity_writing_sentence_theme_search.*
import kotlinx.android.synthetic.main.item_book_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WritingSentenceBookSearchActivity : AppCompatActivity() {

    lateinit var writingSentenceBookSearchAdapter: WritingSentenceBookSearchAdapter
    val datas = mutableListOf<BookData>()
    lateinit var bookSearchData: BookData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing_sentence_book_search)

        activity_writing_sentence_book_search_before.visibility = View.VISIBLE
        activity_writing_sentence_book_search_after.visibility = View.GONE
        activity_writing_sentence_book_search_rv_after.visibility = View.GONE
        activity_writing_sentence_book_search_empty.visibility = View.GONE

        //포커스는 검색창에
        activity_writing_sentence_book_search_tv_search.requestFocus()
        //키보드 등장
        activity_writing_sentence_book_search_tv_search.showKeyboard()

        //글자수 세기기 및 경고 박스 해제
        activity_writing_sentence_book_search_tv_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {


                //실시간 글자 수 세기
                val string_length = activity_writing_sentence_book_search_tv_search.text.toString()
                activity_writing_sentence_book_search_tv_cnt.setText(string_length.length.toString())
            }

        })

        activity_writing_sentence_book_search_btn_out.setOnClickListener {
            finish()
        }


        //뒤로가기 버튼
        activity_writing_sentence_book_search_btn_out.setOnClickListener {
            finish()
        }


       //rv 동작
        writingSentenceBookSearchAdapter = WritingSentenceBookSearchAdapter(this)
        activity_writing_sentence_book_search_rv_after.adapter = writingSentenceBookSearchAdapter
        activity_writing_sentence_book_search_rv_after.addItemDecoration(ItemDecoration())
        //loadDatas()
        //requestData()

        //검색 버튼
        activity_writing_sentence_book_search_btn_search.setOnClickListener {
            //키보드 제어
            activity_writing_sentence_book_search_tv_search.unshowKeyboard()
            //검색 결과가 있으면
            goNextPage(activity_writing_sentence_book_search_before, activity_writing_sentence_book_search_after)
            activity_writing_sentence_book_search_rv_after.visibility = View.VISIBLE
            //loadDatas()
            requestData()



            //검색 결과가 없으면
            //goNextPage(activity_writing_sentence_book_search_before, activity_writing_sentence_book_search_empty)



            //if 서버 통신 성공
            //activity_writing_sentence_theme_search_after.visibility = View.VISIBLE
            //        activity_writing_sentence_theme_search_rv_after.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
//            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {


            //아이템 터치 했을 때, 동작
//            val intent = Intent(this@WritingSentenceThemeSearchActivity, WritingSentenceActivity::class.java)
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
//            goNextPage(activity_writing_sentence_theme_search_rv_after, activity_writing_sentence_theme_search_after2)
//
//            //if 서버 통신 실패
//            goNextPage(activity_writing_sentence_theme_search_rv_after, activity_writing_sentence_theme_search_after2)





        }




    }

//    private fun loadDatas(){
//        datas.apply {
//            add(
//
//                BookData(
//                    authors = "해리",
//                    publisher = "몽글1",
//                    thumbnail = "dsf",
//                    title = "해리포터",
//                    isbn = "dsfa"
//                )
//            )
//            add(
//
//                BookData(
//                    authors = "해리포터",
//                    publisher = "몽글2",
//                    thumbnail = "dsf",
//                    title = "해리포터",
//                    isbn = "dsfa"
//                )
//            )
//            add(
//
//                BookData(
//                    authors = "리",
//                    publisher = "몽글3",
//                    thumbnail = "dsf",
//                    title = "해리포터",
//                    isbn = "dsfa"
//                )
//            )
//            add(
//
//                BookData(
//                    authors = "해리",
//                    publisher = "몽글4",
//                    thumbnail = "dsf",
//                    title = "해리포터",
//                    isbn = "dsfa"
//                )
//            )
//            add(
//
//                BookData(
//                    authors = "해리",
//                    publisher = "몽글5",
//                    thumbnail = "dsf",
//                    title = "해리포터",
//                    isbn = "dsfa"
//                )
//            )
//            writingSentenceBookSearchAdapter.datas = datas
//            writingSentenceBookSearchAdapter.notifyDataSetChanged()
//        }
//    }


    private fun requestData() {
        val call: Call<ResponseWritingSentenceBookSearchData> = RequestToServer.service.RequestWritingSentenceBookSearch(title = "해리")
        call.enqueue(object : Callback<ResponseWritingSentenceBookSearchData> {
            override fun onFailure(call: Call<ResponseWritingSentenceBookSearchData>, t: Throwable) {
                Log.e("requestUser 통신실패",t.toString())
            }
            override fun onResponse(call: Call<ResponseWritingSentenceBookSearchData>, response: Response<ResponseWritingSentenceBookSearchData>) {
                if (response.isSuccessful){
                    response.body().let { body->
                        Log.e("history 통신응답바디", "status: ${body!!.staus} data : ${body!!.message}")
                        //writingSentenceBookSearchAdapter.datas = response.body()?.data!!
                        writingSentenceBookSearchAdapter.datas = body.data
                        //this@WritingSentenceBookSearchActivity.bookSearchData = response.body()?.data!!
//                        bookSearchData = response.body()?.data!!
//                        bookSearchData = body.
//                        item_search_book_tv_author.text = bookSearchData.authors
//                        item_search_book_tv_title.text = bookSearchData.title
                        writingSentenceBookSearchAdapter.notifyDataSetChanged()

                    }
                }

            }
        })
    }




}