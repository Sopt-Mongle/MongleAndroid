package com.example.mongleandroid.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mongleandroid.DialogLogin
import com.example.mongleandroid.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        activity_login_tv_join.setOnClickListener {
            val intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
        }
        activity_login_btn_login.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            activity_login_btn_login.id -> {
                val dlg = DialogLogin(this)
                dlg.setOnOKClickedListener{

                }
                dlg.start("메인?")
            }
        }
    }
}