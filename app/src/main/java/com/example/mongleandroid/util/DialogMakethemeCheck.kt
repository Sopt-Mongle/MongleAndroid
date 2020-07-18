package com.example.mongleandroid.util

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.mongleandroid.R
import com.example.mongleandroid.activity.WritingThemeActivity
import com.example.mongleandroid.activity.WritingThemeFinishActivity
import com.example.mongleandroid.network.RequestToServer
import com.example.mongleandroid.network.SharedPreferenceController
import com.example.mongleandroid.network.data.request.RequestWritingThemeData
import com.example.mongleandroid.network.data.response.ResponseWritingThemeData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DialogMakethemeCheck(context : Context) {
    private val dlg = Dialog(context)   //부모 액티비티의 context 가 들어감
    private lateinit var maketheme_popup_title : ImageView
    private lateinit var maketheme_popup_yes : TextView
    private lateinit var maketheme_popup_no : TextView
    private  lateinit var maketheme_popup_tv_title : TextView
    private lateinit var listener : MyDialogOKClickedListener
    private lateinit var Context: Context
    private lateinit var RequestWritingThemeData: RequestWritingThemeData


    fun start(imgInt: Int, img: String, title: String, context: Context){
        Context = context
        RequestWritingThemeData = RequestWritingThemeData(title,imgInt)

//        when(chkedNum){
//
//            1 -> Glide.with(context).load(imgDataList.get(1).img).into(dlg.findViewById(R.id.maketheme_popup_title))
//            2 -> Glide.with(context).load(imgDataList.get(2).img).into(dlg.findViewById(R.id.maketheme_popup_title))
//            3 -> Glide.with(context).load(imgDataList.get(3).img).into(dlg.findViewById(R.id.maketheme_popup_title))
//            4 -> Glide.with(context).load(imgDataList.get(4).img).into(dlg.findViewById(R.id.maketheme_popup_title))
//            5 -> Glide.with(context).load(imgDataList.get(5).img).into(dlg.findViewById(R.id.maketheme_popup_title))
//            6 -> Glide.with(context).load(imgDataList.get(6).img).into(dlg.findViewById(R.id.maketheme_popup_title))
//            7 -> Glide.with(context).load(imgDataList.get(7).img).into(dlg.findViewById(R.id.maketheme_popup_title))
//            8 -> Glide.with(context).load(imgDataList.get(8).img).into(dlg.findViewById(R.id.maketheme_popup_title))
//            9 -> Glide.with(context).load(imgDataList.get(9).img).into(dlg.findViewById(R.id.maketheme_popup_title))
//            10 -> Glide.with(context).load(imgDataList.get(10).img).into(dlg.findViewById(R.id.maketheme_popup_title))
//            11 -> Glide.with(context).load(imgDataList.get(11).img).into(dlg.findViewById(R.id.maketheme_popup_title))
//            12 -> Glide.with(context).load(imgDataList.get(12).img).into(dlg.findViewById(R.id.maketheme_popup_title))
//            13 -> Glide.with(context).load(imgDataList.get(13).img).into(dlg.findViewById(R.id.maketheme_popup_title))
//            14 -> Glide.with(context).load(imgDataList.get(14).img).into(dlg.findViewById(R.id.maketheme_popup_title))
//            15 -> Glide.with(context).load(imgDataList.get(15).img).into(dlg.findViewById(R.id.maketheme_popup_title))
//            16 -> Glide.with(context).load(imgDataList.get(16).img).into(dlg.findViewById(R.id.maketheme_popup_title))
//
//        }

        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)   //타이틀바 제거
        dlg.setCancelable(false)    //다이얼로그의 바깥 화면을 눌렀을 때 다이얼로그가 닫히지 않도록 함
        dlg.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dlg.setContentView(R.layout.dialog_maketheme_check)     //다이얼로그에 사용할 xml 파일을 불러옴

        maketheme_popup_yes = dlg.findViewById(R.id.maketheme_popup_yes)
        maketheme_popup_no = dlg.findViewById(R.id.maketheme_popup_no)
        maketheme_popup_title = dlg.findViewById(R.id.maketheme_popup_title)
        maketheme_popup_tv_title = dlg.findViewById(R.id.maketheme_popup_tv_title)

        maketheme_popup_tv_title.text = title
        Glide.with(context).load(img).into(dlg.findViewById(R.id.maketheme_popup_title))

        maketheme_popup_yes.setOnClickListener{
            //돌아갈 액티비티
            requestData()
            val intent = Intent(it.context, WritingThemeFinishActivity::class.java)
            it.context.startActivity(intent)
            dlg.dismiss()
        }
        maketheme_popup_no.setOnClickListener {
            dlg.dismiss()
        }


        dlg.show()

    }

    fun setOnOKClickedListener(listener: (String) -> Unit) {
        this.listener = object:
            MyDialogOKClickedListener {
            override fun onOKClicked(content: String) {
                listener(content)
            }
        }
    }


    interface MyDialogOKClickedListener {
        fun onOKClicked(content : String)
    }


    private fun requestData(){
        val call: Call<ResponseWritingThemeData> = RequestToServer.service.RequestWritingTheme(token = SharedPreferenceController.getAccessToken(context = Context), body = RequestWritingThemeData)
        call.enqueue(object : Callback<ResponseWritingThemeData> {
            @SuppressLint("LongLogTag")
            override fun onFailure(call: Call<ResponseWritingThemeData>, t: Throwable) {
                Log.e("ResponseWritingThemeData 통신실패",t.toString())
            }
            @SuppressLint("LongLogTag")
            override fun onResponse(
                call: Call<ResponseWritingThemeData>,
                response: Response<ResponseWritingThemeData>
            ) {
                if (response.isSuccessful){
                    response.body().let { body ->
                        Log.d("ResponseWritingThemeData 통신응답성공바디", "status: ${body!!.status} data : ${body.message}")
                    }
                }else{
                    response.body().let { body ->
                        Log.d("ResponseWritingThemeData 통신응답실바디", "${RequestWritingThemeData.theme} ${RequestWritingThemeData.themeImgIdx} ")
                        
                    }
                }




            }
        })
    }
}
