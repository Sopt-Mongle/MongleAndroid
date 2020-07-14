package com.example.mongleandroid.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.TranslateAnimation
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mongleandroid.*
import kotlinx.android.synthetic.main.activity_writing_sentence.*


class WritingSentenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing_sentence)

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


        //다음가기 버튼
        activity_writing_sentence_btn_next1.setOnClickListener {
            activity_writing_sentence_CL_next1.visibility = View.GONE
            goNextView(activity_writing_sentence_btn_out, activity_writing_sentence_btn_back1)
            goNextPage(activity_writing_sentence_CL_sentence, activity_writing_sentence_CL_book)

            //키보드 제어
            activity_writing_sentence_et_sentence.unshowKeyboard()

        }
        //뒤로가기 버톤
        activity_writing_sentence_btn_out.setOnClickListener {
            onDestroy()
            Toast.makeText(this, "메인화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show()
        }
        //애니메이션
        //에러 메세지
        //키보드


        //문장 만들기 2단계

        //다음가기 버튼
        activity_writing_sentence_btn_next2.setOnClickListener {
            goNextView(activity_writing_sentence_btn_back1, activity_writing_sentence_btn_back2)
            goNextPage(activity_writing_sentence_CL_book, activity_writing_sentence_CL_theme)
        }
        //뒤로가기 버톤
        activity_writing_sentence_btn_back1.setOnClickListener {
            activity_writing_sentence_CL_next1.visibility = View.VISIBLE
            goPrevView(activity_writing_sentence_btn_back1, activity_writing_sentence_btn_out)
            goPrevPage(activity_writing_sentence_CL_book, activity_writing_sentence_CL_sentence)
        }
        //책 검색으로 이동 버튼
        activity_writing_sentence_btn_book_search.setOnClickListener{
            val intent = Intent(this@WritingSentenceActivity,WritingSentenceBookSearchActivity::class.java)
            startActivityForResult(intent,1)
        }
        //애니메이션
        //에러 메세지
        //키보드


        //문장 만들기 3단계

        //다음가기 버튼
        activity_writing_sentence_btn_next3.setOnClickListener {
            activity_writing_sentence_btn_back2.visibility = View.GONE
            goNextPage(activity_writing_sentence_CL_theme, activity_writing_sentence_CL_finish)
        }
        //뒤로가기 버톤
        activity_writing_sentence_btn_back2.setOnClickListener {
            goPrevView(activity_writing_sentence_btn_back2, activity_writing_sentence_btn_back1)
            goPrevPage(activity_writing_sentence_CL_theme,activity_writing_sentence_CL_book)
        }
        //테마 검색으로 이동 버튼
        activity_writing_sentence_btn_theme_search.setOnClickListener {
            val intent = Intent(this@WritingSentenceActivity,WritingSentenceThemeSearchActivity::class.java)
            startActivityForResult(intent,2)
        }
        //애니메이션
        //에러 메세지
        //키보드




    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (data != null) {
                activity_writing_sentence_btn_book_search.setText(data.getStringExtra("title"))
                activity_writing_sentence_tv_author.setText(data.getStringExtra("author"))
                activity_writing_sentence_tv_publisher.setText(data.getStringExtra("publisher"))
            }
        }
        if (requestCode == 2) {
            if (data != null) {
                activity_writing_sentence_tv_theme.setText(data.getStringExtra("theme"))
            }
        }
    }


    override fun onBackPressed() {
        //goPrevPage()
    }


}