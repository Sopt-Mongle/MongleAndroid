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

        // 다음 버튼 눌렀을때, et값이 안채워져있다면 경고창
        activity_theme_writing_sentence_bottombar.setOnClickListener {
            if(activity_theme_writing_sentence_et_sentence.text.toString().length <=  0) {
                activity_theme_writing_sentence_et_sentence.background = getResources().getDrawable(R.drawable.et_area_red)
                activity_theme_writing_sentence_img_warning.visibility = VISIBLE
                activity_theme_writing_sentence_tv_warning.visibility = VISIBLE
            } else {
                val intent = Intent(this, WritingSentenceBookSearchActivity::class.java)
                startActivity(intent)
            }
        }

        activity_theme_writing_sentence_et_sentence.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                activity_theme_writing_sentence_et_sentence.background = getResources().getDrawable(R.drawable.et_area)
                activity_theme_writing_sentence_img_warning.visibility = GONE
                activity_theme_writing_sentence_tv_warning.visibility = GONE

                val string_length = activity_theme_writing_sentence_et_sentence.text.toString()
                activity_theme_writing_sentence_tv_cnt.setText(string_length.length.toString())
            }
        })

    }
}