package com.example.mongleandroid.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mongleandroid.R
import com.example.mongleandroid.network.RequestToServer
import com.example.mongleandroid.network.SharedPreferenceController
import com.example.mongleandroid.network.customEnqueue
import com.example.mongleandroid.network.data.request.RequestLoginData
import com.example.mongleandroid.util.DialogLogin
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    val requestToServer = RequestToServer

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
                requestToServer.service.RequestLoginData(
                    RequestLoginData(
                        email = activity_login_et_email.text.toString(),
                        password = activity_login_et_pass.text.toString()
                    )
                ).customEnqueue(
                    onError = {
                        Log.d("error", "통신 실패")
                        val dlg = DialogLogin(this)
                        dlg.setOnOKClickedListener{ content ->

                        }
                        dlg.start("")
                    },
                    onSuccess = {

                        if(it.status == 200) {

                            Log.e("토큰", " ${it}")
                            SharedPreferenceController.setAccessToken(applicationContext, it.data.accessToken)
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else if (it.status == 400){
                            val dlg = DialogLogin(this)
                            dlg.setOnOKClickedListener{ content ->

                            }
                            dlg.start("")
                        }
                    }
                )


            }
        }
    }
}