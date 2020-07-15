package com.example.mongleandroid.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mongleandroid.R
import com.example.mongleandroid.util.DialogSentenceUpdate
import kotlinx.android.synthetic.main.activity_edit_sentence.*

class EditSentenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_sentence)

        tv_btn_edit.setOnClickListener {
            val dlg = DialogSentenceUpdate(this)
            dlg.setOnOKClickedListener{ content ->

            }
            dlg.start("")
        }

    }
}