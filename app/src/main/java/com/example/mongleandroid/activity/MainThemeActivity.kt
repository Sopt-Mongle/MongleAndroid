package com.example.mongleandroid.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log
import android.view.View
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.CuratorKeywordAdapter
import com.example.mongleandroid.adapter.MainThemeAdapter
import com.example.mongleandroid.network.RequestToServer
import com.example.mongleandroid.network.SharedPreferenceController
import com.example.mongleandroid.network.data.response.DataTheme
import com.example.mongleandroid.network.data.response.ResponseCuratorKeywordData
import com.example.mongleandroid.network.data.response.ResponseThemeDetailData
import com.example.mongleandroid.network.data.response.ThemeDetailData
import kotlinx.android.synthetic.main.activity_curator.*
import kotlinx.android.synthetic.main.activity_main_theme.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainThemeActivity : AppCompatActivity() {

    val requestToServer = RequestToServer//싱글톤 그대로 가져옴

    private var data = mutableListOf<ResponseThemeDetailData>()

    private lateinit var mainThemeAdapter : MainThemeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_theme)
        //setMainThemeAdapter(data)

        requestThemeData()
        requestMainThemeData()
        img_main_theme_activity_back_btn.setOnClickListener {
            finish()
        }
        img_writing_sentence_in_theme_btn.setOnClickListener {
            val intent = Intent(this, ThemeWritingSentenceActivity::class.java)
            startActivity(intent)
        }
    }

    private fun requestThemeData() {
        requestToServer.service.GetDetailTheme(
            token = applicationContext?.let { SharedPreferenceController.getAccessToken(it) },
            params = intent.getIntExtra("param", 0)
        ).enqueue(
            object : retrofit2.Callback<ResponseThemeDetailData> {
                override fun onFailure(call: Call<ResponseThemeDetailData>, t: Throwable) {
                    Log.e("통신 실패", t.toString())
                }

                override fun onResponse(
                    call: Call<ResponseThemeDetailData>,
                    response: Response<ResponseThemeDetailData>
                ) {
                    if(response.isSuccessful) {
                        tv_main_theme_title.text = response.body()!!.data!!.theme[0].theme
                        tv_main_theme_author.text = response.body()!!.data!!.theme[0].writer
                        textView12.text = response.body()!!.data!!.theme[0].sentenceNum.toString()
                        textView11.text = response.body()!!.data!!.theme[0].saves.toString()
                    }
                }

            }
        )
    }

    private fun requestMainThemeData() {

        requestToServer.service.GetDetailTheme(
            token = applicationContext?.let { SharedPreferenceController.getAccessToken(it) },
            params = intent.getIntExtra("param", 0)
        ).enqueue(
            object : retrofit2.Callback<ResponseThemeDetailData> {


                override fun onFailure(call: Call<ResponseThemeDetailData>, t: Throwable) {
                    Log.e("통신 실패", t.toString())
                }

                override fun onResponse(
                    call: Call<ResponseThemeDetailData>,
                    response: Response<ResponseThemeDetailData>
                ) {
                    if(response. isSuccessful) {
                        Log.d("테마 통신 성공", "${response.body()!!.data}")
                        //rv_activity_theme.adapter = mainThemeAdapter

                        mainThemeAdapter = MainThemeAdapter( response.body()!!.data!!.sentence , applicationContext)
                        rv_activity_theme.adapter = mainThemeAdapter
                        mainThemeAdapter.notifyDataSetChanged()

                        //리사이클러뷰 아이템 클릭리스너 등록
                        mainThemeAdapter.setItemClickListener(object : MainThemeAdapter.ItemClickListener{
                            override fun onClick(view: View, position: Int) {
                                Log.d("SSS","${position}번 리스트 선택")
                                val intent = Intent(this@MainThemeActivity, SentenceDetailViewInThemeActivity::class.java)
                                startActivity(intent)
                            }
                        })
                    }
                }
            })
    }

//    private fun setMainThemeAdapter(mainThemeItem: MutableList<ResponseThemeDetailData>) {
////        mainThemeAdapter =
////            MainThemeAdapter(
////                mainThemeItem,
////                this
////            )
////        loadDatas()
//        rv_activity_theme.adapter = mainThemeAdapter
//
//        //리사이클러뷰 아이템 클릭리스너 등록
//        mainThemeAdapter.setItemClickListener(object : MainThemeAdapter.ItemClickListener{
//            override fun onClick(view: View, position: Int) {
//                Log.d("SSS","${position}번 리스트 선택")
//                    val intent = Intent(this@MainThemeActivity, SentenceDetailViewInThemeActivity::class.java)
//                    startActivity(intent)
//            }
//        })
//    }

}