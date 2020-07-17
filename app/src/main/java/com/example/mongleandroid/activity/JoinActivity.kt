package com.example.mongleandroid.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import com.example.mongleandroid.R
import com.example.mongleandroid.network.RequestToServer
import com.example.mongleandroid.network.SharedPreferenceController
import com.example.mongleandroid.network.customEnqueue
import com.example.mongleandroid.network.data.request.RequestJoinData
import kotlinx.android.synthetic.main.activity_join.*

class JoinActivity : AppCompatActivity() {

    val requestToServer = RequestToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        activity_join_btn_close.setOnClickListener {
            finish()
        }

        activity_join_btn_next.setOnClickListener {
            if(activity_join_et_email.text.toString().length <=  0) {
                activity_join_et_email.background = getResources().getDrawable(R.drawable.et_area_red)
                activity_join_img_email_warning.visibility = VISIBLE
                activity_join_tv_email_warning.visibility = VISIBLE
            } else if (activity_join_et_pass.text.toString().length <= 0) {
                activity_join_et_pass.background = getResources().getDrawable(R.drawable.et_area_red)
                activity_join_et_passcheck.background = getResources().getDrawable(R.drawable.et_area_red)
                activity_join_img_pass_warning.visibility = VISIBLE
                activity_join_tv_pass_warning.visibility = VISIBLE
            } else if (activity_join_et_passcheck.text.toString().length <= 0) {
                activity_join_et_passcheck.background = getResources().getDrawable(R.drawable.et_area_red)
                activity_join_img_pass_warning.visibility = VISIBLE
                activity_join_tv_passck_warning.visibility = VISIBLE
                activity_join_tv_nomatch_warning.visibility = GONE
            } else if (activity_join_et_nickname.text.toString().length <= 0) {
                activity_join_et_nickname.background = getResources().getDrawable(R.drawable.et_area_red)
                activity_join_img_nickname_warning.visibility = VISIBLE
                activity_join_tv_nickname_warning.visibility = VISIBLE
            } else {
                // 통신 부분
                activity_join_btn_next.setOnClickListener {
                    requestToServer.service.RequestJoinData(
                        RequestJoinData(
                            email = activity_join_et_email.text.toString(),
                            password = activity_join_et_pass.text.toString(),
                            name = activity_join_et_nickname.text.toString()
                        )
                    ).customEnqueue(
                        onError = {
                            Log.d("error", "통신 실패")
                            activity_join_img_nickname_warning.visibility = VISIBLE
                            activity_join_tv_exist_nickname.visibility = VISIBLE
                        },
                        onSuccess = {
                            if(it.status == 200) {
                                activity_join_img_nickname_warning.visibility = GONE
                                activity_join_tv_exist_nickname.visibility = GONE
                                SharedPreferenceController.setAccessToken(applicationContext, it.data.accessToken)
                                val intent = Intent(this@JoinActivity, JoinFinishActivity::class.java)
                                startActivity(intent)
                                finish()
                            } else if (it.status == 400) {
                                Log.d("400 error", "이미 사용중인 닉네임")
                                activity_join_img_nickname_warning.visibility = VISIBLE
                                activity_join_tv_exist_nickname.visibility = VISIBLE
                            } else {
                                Log.d("600 error", "서버 내부 오류")
                            }
                        }
                    )


                }

            }


        }



        // email 입력창 warning 문구 해제
        activity_join_et_email.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                activity_join_et_email.background = getResources().getDrawable(R.drawable.et_area)
                activity_join_img_email_warning.visibility = GONE
                activity_join_tv_email_warning.visibility = GONE
            }
        })

        // password 입력창 warning 문구 해제
        activity_join_et_pass.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                activity_join_et_pass.background = getResources().getDrawable(R.drawable.et_area)
                activity_join_img_pass_warning.visibility = GONE
                activity_join_tv_pass_warning.visibility = GONE
                activity_join_et_passcheck.background = getResources().getDrawable(R.drawable.et_area)
                activity_join_tv_passck_warning.visibility = GONE

                // 패스워드와 패스워드 확인 값이 다르면
                if(activity_join_et_pass.text.toString() != activity_join_et_passcheck.text.toString()) {
                    activity_join_img_pass_warning.visibility = VISIBLE
                    activity_join_tv_nomatch_warning.visibility = VISIBLE
                    activity_join_img_pass_ok.visibility = GONE
                    activity_join_tv_pass_ok.visibility = GONE
                } else {
                    activity_join_img_pass_warning.visibility = GONE
                    activity_join_tv_nomatch_warning.visibility = GONE
                    activity_join_img_pass_ok.visibility = VISIBLE
                    activity_join_tv_pass_ok.visibility = VISIBLE
                }

                if(activity_join_et_pass.text.toString().isEmpty() && activity_join_et_passcheck.text.toString().isEmpty()) {
                    activity_join_img_pass_ok.visibility = GONE
                    activity_join_tv_pass_ok.visibility = GONE
                }

            }
        })

        // password 확인창 warning 문구 해제
        activity_join_et_passcheck.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                // 패스워드와 패스워드 확인 값이 다르면
                if(activity_join_et_pass.text.toString() != activity_join_et_passcheck.text.toString()) {
                    activity_join_img_pass_warning.visibility = VISIBLE
                    activity_join_tv_nomatch_warning.visibility = VISIBLE
                    activity_join_img_pass_ok.visibility = GONE
                    activity_join_tv_pass_ok.visibility = GONE
                } else {
                    activity_join_img_pass_warning.visibility = GONE
                    activity_join_tv_nomatch_warning.visibility = GONE
                    activity_join_img_pass_ok.visibility = VISIBLE
                    activity_join_tv_pass_ok.visibility = VISIBLE
                }

                if(activity_join_et_pass.text.toString().isEmpty() && activity_join_et_passcheck.text.toString().isEmpty()) {
                    activity_join_img_pass_ok.visibility = GONE
                    activity_join_tv_pass_ok.visibility = GONE
                }

                activity_join_et_passcheck.background = getResources().getDrawable(R.drawable.et_area)
                activity_join_tv_passck_warning.visibility = GONE


            }
        })

        // nickname 입력창 warning 문구 해제
        activity_join_et_nickname.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            @SuppressLint("ResourceAsColor")
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                activity_join_et_nickname.background = getResources().getDrawable(R.drawable.et_area)
                activity_join_img_nickname_warning.visibility = GONE
                activity_join_tv_nickname_warning.visibility = GONE
                activity_join_tv_exist_nickname.visibility = GONE

                // 실시간 글자수
                if(activity_join_et_nickname.text.toString().isEmpty()) {
                    activity_join_tv_nickname_cnt.visibility = GONE
                    activity_join_tv_nickname_cnt_max.visibility = GONE
                } else {
                    activity_join_tv_nickname_cnt.visibility = VISIBLE
                    activity_join_tv_nickname_cnt_max.visibility = VISIBLE
                    val string_length = activity_join_et_nickname.text.toString()
                    activity_join_tv_nickname_cnt.setText(string_length.length.toString())
                    activity_join_tv_nickname_cnt.setTextColor(Color.rgb(115,192,136))
                }

            }
        })



    }
}