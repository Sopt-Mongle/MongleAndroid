package com.example.mongleandroid.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View.GONE
import android.view.View.VISIBLE
import com.example.mongleandroid.R
import kotlinx.android.synthetic.main.activity_theme_writing_sentence.*

class ThemeWritingSentenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_writing_sentence)

        // 테마에 문장쓰기 - 다음 버튼 눌렀을때, et값이 안채워져있다면 경고창
        activity_theme_writing_sentence_btn_next.setOnClickListener {
            if(activity_theme_writing_sentence_et_sentence.text.toString().length <=  0) {
                activity_theme_writing_sentence_et_sentence.background = getResources().getDrawable(R.drawable.et_area_red)
                activity_theme_writing_sentence_img_warning.visibility = VISIBLE
                activity_theme_writing_sentence_tv_warning.visibility = VISIBLE
            } else {
                // et 값이 채워져있다면
                // 책 추가로 이동
                val intent = Intent(this, ThemeWritingSentenceBookActivity::class.java)
                startActivity(intent)
            }
        }
        //다음 버튼
        activity_theme_writing_sentence_btn_out.setOnClickListener {
            val intent = Intent(this, ThemeWritingSentenceBookActivity::class.java)
            startActivity(intent)
        }

        //테마 없는 문장 불러오기
        activity_theme_writing_sentence_btn_notheme.setOnClickListener {
            val intent = Intent(this, NoThemeActivity::class.java)
            startActivity(intent)
        }

        // 테마에 문장쓰기 - 글자수 실시간 계산
        // 글자수 제한은 xml 파일의 maxlength에서 설정
        activity_theme_writing_sentence_et_sentence.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // warning 문구 해제
                activity_theme_writing_sentence_et_sentence.background = getResources().getDrawable(R.drawable.et_area)
                activity_theme_writing_sentence_img_warning.visibility = GONE
                activity_theme_writing_sentence_tv_warning.visibility = GONE

                // 실시간 글자수
                val string_length = activity_theme_writing_sentence_et_sentence.text.toString()
                activity_theme_writing_sentence_tv_cnt.setText(string_length.length.toString())
            }
        })

    }
}