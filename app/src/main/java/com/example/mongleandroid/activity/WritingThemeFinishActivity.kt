package com.example.mongleandroid.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mongleandroid.R
import kotlinx.android.synthetic.main.activity_writing_theme_finish.*

class WritingThemeFinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing_theme_finish)
        activity_writing_theme_btn_writing.setOnClickListener {
            val intent = Intent(this, ThemeWritingSentenceActivity::class.java)
            startActivity(intent)
            finish()
        }
        activity_writing_sentence_btn_main.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()


        }
    }
}