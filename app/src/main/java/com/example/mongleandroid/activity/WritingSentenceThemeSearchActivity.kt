package com.example.mongleandroid.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mongleandroid.*
import com.example.mongleandroid.adapter.ItemDecoration
import com.example.mongleandroid.adapter.WritingSentenceBookSearchAdapter
import com.example.mongleandroid.adapter.WritingSentenceThemeSearchAdapter
import com.example.mongleandroid.network.RequestToServer
import com.example.mongleandroid.network.data.response.ResponseWritingSentenceBookSearchData
import com.example.mongleandroid.network.data.response.ResponseWritingSentenceThemeSearchData
import com.example.mongleandroid.network.data.response.ThemeData
import kotlinx.android.synthetic.main.activity_writing_sentence.*
import kotlinx.android.synthetic.main.activity_writing_sentence_book_search.*
import kotlinx.android.synthetic.main.activity_writing_sentence_theme_search.*
import kotlinx.android.synthetic.main.item_book_search.*
import kotlinx.android.synthetic.main.item_theme_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WritingSentenceThemeSearchActivity : AppCompatActivity() {

    lateinit var writingSentenceThemeSearchAdapter : WritingSentenceThemeSearchAdapter
    val datas = mutableListOf<ThemeData>()
    var title : String = ""
    var themeIdx : Int = -1
    var chkedidx : Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing_sentence_theme_search)

        //키보드는 숨기
        activity_writing_sentence_theme_search_v_title.unshowKeyboard()

        //글자수 세기기 및 경고 박스 해제
        activity_writing_sentence_theme_search_v_title.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //빨간 박스 해제
                activity_writing_sentence_theme_search_warning.visibility = View.GONE

//                //실시간 글자 수 세기
//                val string_length = activity_writing_sentence_theme_search_v_title.text.toString()
//                activity_writing_sentence_tv_cnt.setText(string_length.length.toString())
            }

        })


        val myLayoutManager = GridLayoutManager(this, 2)
        activity_writing_sentence_theme_search_rv_after.layoutManager = myLayoutManager
        writingSentenceThemeSearchAdapter = WritingSentenceThemeSearchAdapter(this)
        activity_writing_sentence_theme_search_rv_after.adapter = writingSentenceThemeSearchAdapter
        activity_writing_sentence_theme_search_rv_after.addItemDecoration(ItemDecoration())
        requestDefaultData()


        //뒤로가기 버튼
        activity_writing_sentence_theme_search_btn_out.setOnClickListener {
            finish()
        }
        //등록하기 버튼
        activity_writing_sentence_btn_next.setOnClickListener {
            var intent : Intent = Intent(this@WritingSentenceThemeSearchActivity, WritingSentenceActivity::class.java)
            intent.putExtra("theme", title)
            intent.putExtra("themeIdx", themeIdx)
            Log.d("theme","${ title}번 리스트 선택")
            setResult(2, intent)
            finish()


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
            datas.clear()
            requestDefaultData()
        }

    }

    private fun requestDefaultData() {
        val call: Call<ResponseWritingSentenceThemeSearchData> = RequestToServer.service.RequestWritingSentenceThemeSearch()
        call.enqueue(object : Callback<ResponseWritingSentenceThemeSearchData> {
            @SuppressLint("LongLogTag")
            override fun onFailure(
                call: Call<ResponseWritingSentenceThemeSearchData>,
                t: Throwable
            ) {
                Log.e("ResponseWritingSentenceThemeSearchData 통신실패",t.toString())
            }
            @SuppressLint("LongLogTag")
            override fun onResponse(call: Call<ResponseWritingSentenceThemeSearchData>, response: Response<ResponseWritingSentenceThemeSearchData>) {
                if (response.isSuccessful) {
                    response.body().let { body ->
                        Log.e(
                            "ResponseWritingSentenceThemeSearchData 통신응답바디",
                            "status: ${body!!.staus} data : ${body!!.message}"
                        )
                        writingSentenceThemeSearchAdapter.datas = body.data
                        writingSentenceThemeSearchAdapter.notifyDataSetChanged()


                        if(body.data.size == 0){
                            //if 서버 통신 성공 && 결과 없음
                            activity_writing_sentence_theme_search_rv_after.visibility = View.GONE
                            activity_writing_sentence_theme_search_after.visibility = View.GONE
                            activity_writing_sentence_theme_search_empty.visibility = View.VISIBLE

                        }else{
                            //if 서버 통신 성공 && 결과 있음
                            activity_writing_sentence_theme_search_empty.visibility = View.GONE
                            activity_writing_sentence_theme_search_after.visibility = View.VISIBLE
                            activity_writing_sentence_theme_search_rv_after.visibility = View.VISIBLE
                            activity_writing_sentence_theme_search_tv3.text = title
                            activity_writing_sentence_theme_search_tv5.text = "총 " + body.data.size.toString() + "건"

                            //리사이클러뷰 아이템 클릭리스너 등록
                            writingSentenceThemeSearchAdapter.setItemClickListener(object : WritingSentenceThemeSearchAdapter.ItemClickListener{
                                override fun onClick(view: View, position: Int) {
                                    if(chkedidx != -1){
                                        activity_writing_sentence_theme_search_rv_after.getChildAt(chkedidx).findViewById<ImageView>(R.id.activity_search_theme_img_chk).visibility = View.GONE
                                    }
                                    title = writingSentenceThemeSearchAdapter.datas[position].theme
                                    themeIdx = writingSentenceThemeSearchAdapter.datas[position].themeIdx
                                    view.findViewById<ImageView>(R.id.activity_search_theme_img_chk).visibility = View.VISIBLE
                                    Log.d("SSS","${position}번 리스트 선택")
                                    chkedidx = position
                                }
                            })
                        }
                    }
                }else{
                    //if 서버 통신 실패
                    Log.d("서버 통신", "테마 검색 서버 통신 실패")
                }

            }
        })
    }
}