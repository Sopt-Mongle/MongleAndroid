package com.example.mongleandroid.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.TranslateAnimation
import android.widget.Toast
import androidx.constraintlayout.solver.widgets.ConstraintWidget.GONE
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.example.mongleandroid.*
import com.example.mongleandroid.network.RequestToServer
import com.example.mongleandroid.network.SharedPreferenceController
import com.example.mongleandroid.network.data.request.RequestWritingSentenceData
import com.example.mongleandroid.network.data.request.RequestWritingThemeData
import com.example.mongleandroid.network.data.response.ResponseWritingSentenceData
import com.example.mongleandroid.network.data.response.ResponseWritingThemeData
import kotlinx.android.synthetic.main.activity_theme_writing_sentence.*
import kotlinx.android.synthetic.main.activity_writing_sentence.*
import kotlinx.android.synthetic.main.activity_writing_sentence.activity_writing_sentence_btn_main
import kotlinx.android.synthetic.main.activity_writing_theme.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WritingSentenceActivity : AppCompatActivity() {

    lateinit var progressBar_go: Animation
    lateinit var progressBar_back: Animation
    lateinit var state_gray: Animation
    lateinit var state_green: Animation
//    lateinit var sentence: String	//작성할 문장
//    lateinit var title:	String	//작성할 문장이 속한 책 제목
//    lateinit var author:	String	//작성할 문장이 속한 책의 저자
//    lateinit var publisher:	String //작성할 문장이 속한 책 출판사
//    var themeIdx:	Int = -1	//선택한 테마의 idx(0 : 테마 없는 테마, 그외 : 해당 테마)
    var RequestWritingSentenceData : RequestWritingSentenceData = RequestWritingSentenceData("","","","",-1)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing_sentence)




        //경고 메세지

        //애니메이션

        //키보드 제어


        //애니메이션
        progressBar_go = AnimationUtils.loadAnimation(this, R.anim.progressbar_go)
        progressBar_back = AnimationUtils.loadAnimation(this, R.anim.progressbar_back)
        state_gray = AnimationUtils.loadAnimation(this, R.anim.state_gray)
        state_green = AnimationUtils.loadAnimation(this, R.anim.state_green)


        //뷰 일단 다 없애고 시작
        activity_writing_sentence_CL_topbar.visibility = View.GONE
        activity_writing_sentence_CL_sentence.visibility = View.GONE
        activity_writing_sentence_CL_book.visibility = View.GONE
        activity_writing_sentence_CL_theme.visibility = View.GONE
        activity_writing_sentence_CL_next1.visibility = View.GONE
        activity_writing_sentence_CL_finish.visibility = View.GONE


        //문장 만들기 1단계
        activity_writing_sentence_CL_topbar.visibility = View.VISIBLE
        activity_writing_sentence_CL_sentence.visibility = View.VISIBLE
        activity_writing_sentence_CL_next1.visibility = View.VISIBLE
        activity_writing_sentence_btn_out.visibility = View.VISIBLE

        //키보드 제어
        activity_writing_sentence_et_sentence.requestFocus()
        activity_writing_sentence_et_sentence.showKeyboard()


        //글자수 세기기 및 경고 박스 해제
        activity_writing_sentence_et_sentence.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //빨간 박스 해제
                goPrevPage(activity_writing_sentence_CL_sentence_warning, activity_writing_sentence_CL_sentence_normal)

                //실시간 글자 수 세기
                val string_length = activity_writing_sentence_et_sentence.text.toString()
                activity_writing_sentence_tv_cnt.setText(string_length.length.toString())
            }

        })



        //다음가기 버튼
        activity_writing_sentence_btn_next1.setOnClickListener {
            //경고 메세지
            if(activity_writing_sentence_et_sentence.text.toString().length <=0){
                goNextPage(activity_writing_sentence_CL_sentence_normal, activity_writing_sentence_CL_sentence_warning)
            }else{
                RequestWritingSentenceData.sentence = activity_writing_sentence_et_sentence.text.toString()
                activity_writing_sentence_CL_next1.visibility = View.GONE
                goNextView(activity_writing_sentence_btn_out, activity_writing_sentence_btn_back1)
                goNextPage(activity_writing_sentence_CL_sentence, activity_writing_sentence_CL_book)
                //키보드 제어
                activity_writing_sentence_et_sentence.unshowKeyboard()
            }



            //애니메이션

            //키보드 제어


        }
        //뒤로가기 버톤
        activity_writing_sentence_btn_out.setOnClickListener {
            Toast.makeText(this, "메인화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show()
            finish()

        }
        //애니메이션






        //문장 만들기 2단계


        //경고 메세지 해제
        activity_writing_sentence_btn_book_search_nomal.addTextChangedListener(object  :TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //경고 메세지 해제
                activity_writing_sentence_btn_book_search_nomal.background = getResources().getDrawable(R.drawable.et_area)
                activity_writing_sentence_CL_book_warning.visibility = View.GONE
            }


        })


        //다음가기 버튼
        activity_writing_sentence_btn_next2.setOnClickListener {
            //경고 메세지
            if(activity_writing_sentence_btn_book_search_nomal.text.toString().length <=0){
                activity_writing_sentence_btn_book_search_nomal.background = getResources().getDrawable(R.drawable.et_area_red)
                activity_writing_sentence_CL_book_warning.visibility = View.VISIBLE
            }else{
                RequestWritingSentenceData.title = activity_writing_sentence_btn_book_search_nomal.text.toString()
                RequestWritingSentenceData.author = activity_writing_sentence_tv_author.text.toString()
                RequestWritingSentenceData.publisher = activity_writing_sentence_tv_publisher.text.toString()
                goNextView(activity_writing_sentence_btn_back1, activity_writing_sentence_btn_back2)
                goNextPage(activity_writing_sentence_CL_book, activity_writing_sentence_CL_theme)
            }

            //애니메이션
            //키보드 제어

        }

        //뒤로가기 버톤
        activity_writing_sentence_btn_back1.setOnClickListener {
            //애니메이션

            //키보드 제어
            activity_writing_sentence_CL_next1.visibility = View.VISIBLE
            goPrevView(activity_writing_sentence_btn_back1, activity_writing_sentence_btn_out)
            goPrevPage(activity_writing_sentence_CL_book, activity_writing_sentence_CL_sentence)
        }
        //책 검색으로 이동 버튼
        activity_writing_sentence_btn_book_search_nomal.setOnClickListener{
            val intent = Intent(this@WritingSentenceActivity,WritingSentenceBookSearchActivity::class.java)
            startActivityForResult(intent,1)
        }
        //애니메이션
        //에러 메세지


        //문장 만들기 3단계
        activity_writing_sentence_tv_theme.addTextChangedListener(object  :TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                activity_writing_sentence_btn_theme_search_normal.background = getResources().getDrawable(R.drawable.et_area)
                activity_writing_sentence_CL_theme_warning.visibility = View.GONE
            }


        })

        //다음가기 버튼
        activity_writing_sentence_btn_next3.setOnClickListener {
            //경고 메세지
                if(activity_writing_sentence_tv_theme.text.toString().length <=0){
                    activity_writing_sentence_btn_theme_search_normal.background = getResources().getDrawable(R.drawable.et_area_red)
                    activity_writing_sentence_CL_theme_warning.visibility = View.VISIBLE
                }else{
                    activity_writing_sentence_btn_back2.visibility = View.GONE
                    activity_writing_sentence_CL_topbar.visibility = View.GONE
                    goNextPage(activity_writing_sentence_CL_theme, activity_writing_sentence_CL_finish)
                    Log.d("내가 넣은 값", "${RequestWritingSentenceData.sentence}&& ${RequestWritingSentenceData.title} && ${RequestWritingSentenceData.author} &&${RequestWritingSentenceData.publisher}&&${RequestWritingSentenceData.themeIdx}")

                    requestData()

                }

            //애니메이션

            //키보드 제어

        }
        //뒤로가기 버톤
        activity_writing_sentence_btn_back2.setOnClickListener {
            //경고 메세지

            //애니메이션

            //키보드 제어
            goPrevView(activity_writing_sentence_btn_back2, activity_writing_sentence_btn_back1)
            goPrevPage(activity_writing_sentence_CL_theme,activity_writing_sentence_CL_book)
        }
        //테마 검색으로 이동 버튼
        activity_writing_sentence_btn_theme_search_normal.setOnClickListener {
            val intent = Intent(this@WritingSentenceActivity,WritingSentenceThemeSearchActivity::class.java)
            startActivityForResult(intent,2)
        }
        //애니메이션
        //에러 메세지


        //finish에서 문장 확인하러가기
        activity_writing_sentence_btn_writing.setOnClickListener {
            val intent = Intent(this@WritingSentenceActivity,SentenceDetailViewActivity::class.java)
            startActivity(intent)

        }


        //finish에서 메인으로 돌아가기
        activity_writing_sentence_btn_main.setOnClickListener {
            finish()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (data != null) {
                activity_writing_sentence_btn_book_search_nomal.setText(data.getStringExtra("title"))
                activity_writing_sentence_tv_author.setText(data.getStringExtra("author"))
                activity_writing_sentence_tv_publisher.setText(data.getStringExtra("publisher"))
            }
        }
        if (requestCode == 2) {
            if (data != null) {
                activity_writing_sentence_tv_theme.setText(data.getStringExtra("theme"))
                RequestWritingSentenceData.themeIdx = data.getIntExtra("themeIdx", 24)

            }
        }
    }


    override fun onBackPressed() {
        //goPrevPage()
    }


    private fun requestData(){
        val call: Call<ResponseWritingSentenceData> = RequestToServer.service.RequestWritingSentence(token = SharedPreferenceController.getAccessToken(context = this),body = RequestWritingSentenceData)
        call.enqueue(object : Callback<ResponseWritingSentenceData> {
            @SuppressLint("LongLogTag")
            override fun onFailure(call: Call<ResponseWritingSentenceData>, t: Throwable) {
                Log.e("ResponseWritingSentenceData 통신실패",t.toString())
            }
            @SuppressLint("LongLogTag")
            override fun onResponse(
                call: Call<ResponseWritingSentenceData>,
                response: Response<ResponseWritingSentenceData>
            ) { if (response.isSuccessful){
                    response.body().let { body ->
                        Log.e("ResponseWritingSentenceData 통신응답바디", "status: ${body!!.status} data : ${body!!.message}")
                    }
                }else{
                   // Log.e("ResponseWritingSentenceData 통신응답바디", "status: ${response.body()!!.status} data: ${response.body()!!.message}" )
                }

            }

        })

    }


}