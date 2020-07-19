package com.example.mongleandroid.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mongleandroid.R
import kotlinx.android.synthetic.main.activity_theme_writing_sentence.*
import kotlinx.android.synthetic.main.activity_theme_writing_sentence_book.*

class ThemeWritingSentenceBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_writing_sentence_book)

        // 책 추가
        activity_theme_writing_sentence_book_tv_title.setOnClickListener {
            val intent = Intent(this, WritingSentenceBookSearchActivity::class.java)
            startActivityForResult(intent, 100)
            // 이거 아마 startActivityForResult로 바꿔야 함!!
        }

        activity_theme_writing_sentence_book_btn_out.setOnClickListener {
            finish()
        }


        // 책 제목 text가 없는 경우 경고창
        activity_theme_writing_sentence_book_btn_upload.setOnClickListener {
            if(activity_theme_writing_sentence_book_tv_title.text.toString().length <= 0) {
                activity_theme_writing_sentence_book_tv_title.background = getResources().getDrawable(R.drawable.et_area_red)
                activity_theme_writing_sentence_book_img_warning.visibility = View.VISIBLE
                activity_theme_writing_sentence_book_tv_warning.visibility = View.VISIBLE
            } else {
                // 있는 경우
                // 다음 액티비티로 이동 (문장 등록 끝)
                activity_theme_writing_sentence_book_tv_title.background = getResources().getDrawable(R.drawable.et_area)
                activity_theme_writing_sentence_book_img_warning.visibility = View.GONE
                activity_theme_writing_sentence_book_tv_warning.visibility = View.GONE
                val intent = Intent(this, WritingSentenceInThemeFinishActivity::class.java )
                startActivity(intent)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100) {
            if( resultCode == 1) {
                val title = data!!.getStringExtra("title")
                val author = data!!.getStringExtra("author")
                val publisher = data!!.getStringExtra("publisher")

                activity_theme_writing_sentence_book_tv_title.setText(title)
                activity_theme_writing_sentence_book_v_author.setText(author)
                activity_theme_writing_sentence_book_v_publisher.setText(publisher)

                activity_theme_writing_sentence_book_tv_hint.visibility = View.GONE
            }
        }
    }
}