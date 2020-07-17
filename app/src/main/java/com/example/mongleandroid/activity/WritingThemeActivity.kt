package com.example.mongleandroid.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mongleandroid.*
import com.example.mongleandroid.network.RequestToServer
import com.example.mongleandroid.network.SharedPreferenceController
import com.example.mongleandroid.network.data.request.RequestWritingThemeData
import com.example.mongleandroid.network.data.response.ImgData
import com.example.mongleandroid.network.data.response.ResponseThemeImgData
import com.example.mongleandroid.network.data.response.ResponseWritingThemeData
import com.example.mongleandroid.util.DialogMakethemeCheck
import kotlinx.android.synthetic.main.activity_writing_theme.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WritingThemeActivity : AppCompatActivity() {
    var datas: MutableList<RequestWritingThemeData> = mutableListOf<RequestWritingThemeData>()
    var Imgdatas: MutableList<ImgData> = mutableListOf<ImgData>()
    var themeImgIdx:Int = 0
    lateinit var img:String
    var RequestWritingThemeData: RequestWritingThemeData = RequestWritingThemeData("dd", 1)
    data class imgData(
        var img: String,
        var imgIdx: Int
    )
    var imgDataList: MutableList<imgData> = MutableList(16,{imgData("",0)})


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing_theme)
        requestThemeImgData()

        activity_writing_theme_et_theme_title.requestFocus()
        activity_writing_theme_et_theme_title.showKeyboard()

        var imgchked1 : ConstraintLayout = findViewById(R.id.activity_writing_theme_CL_img1)
        var imgchked2 : ConstraintLayout = findViewById(R.id.activity_writing_theme_CL_img2)
        var imgchked3 : ConstraintLayout = findViewById(R.id.activity_writing_theme_CL_img3)
        var imgchked4 : ConstraintLayout = findViewById(R.id.activity_writing_theme_CL_img4)
        var imgchked5 : ConstraintLayout = findViewById(R.id.activity_writing_theme_CL_img5)
        var imgchked6 : ConstraintLayout = findViewById(R.id.activity_writing_theme_CL_img6)
        var imgchked7 : ConstraintLayout = findViewById(R.id.activity_writing_theme_CL_img7)
        var imgchked8 : ConstraintLayout = findViewById(R.id.activity_writing_theme_CL_img8)
        var imgchked9 : ConstraintLayout = findViewById(R.id.activity_writing_theme_CL_img9)
        var imgchked10 : ConstraintLayout = findViewById(R.id.activity_writing_theme_CL_img10)

        chked(imgchked1,1)
        chked(imgchked2,2)
        chked(imgchked3,3)
        chked(imgchked4,4)
        chked(imgchked5,5)
        chked(imgchked6,6)
        chked(imgchked7,7)
        chked(imgchked8,8)
        chked(imgchked9,9)
        chked(imgchked10,10)

        activity_writing_theme_et_theme_title.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //빨간 박스 해제
                goPrevPage(activity_writing_theme_CL_warning, activity_writing_theme_CL_nomal)

                //실시간 글자 수 세기
                val string_length = activity_writing_theme_et_theme_title.text.toString()
                activity_writing_theme_tv_cnt.setText(string_length.length.toString())
            }
        })


        //등록하기 버튼
        activity_theme_writing_sentence_btn_upload.setOnClickListener {
            //경고 메세지
            if(activity_writing_theme_et_theme_title.text.toString().length <=0){
                goNextPage(activity_writing_theme_CL_nomal, activity_writing_theme_CL_warning)
            }

            if(activity_writing_theme_et_theme_title.text.toString().length <=0 && themeImgIdx == 0){
                goNextPage(activity_writing_theme_CL_nomal, activity_writing_theme_CL_warning)
                activity_writing_theme_CL_warning2.visibility = View.VISIBLE
            }
            if(themeImgIdx == 0){
                activity_writing_theme_CL_warning2.visibility = View.VISIBLE
            }
            if(activity_writing_theme_et_theme_title.text.toString().length>0 && themeImgIdx > 0){
                RequestWritingThemeData.theme = activity_writing_theme_et_theme_title.text.toString()
                val dlg = DialogMakethemeCheck(this)
                dlg.setOnOKClickedListener{ content ->
                }
                dlg.start(themeImgIdx, imgDataList, this)
                //키보드 제어
                requestData()
                activity_writing_theme_et_theme_title.unshowKeyboard()
            }
        }

        //뒤로가기 버튼
        activity_writing_theme_btn_out.setOnClickListener {
            Toast.makeText(this, "메인화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show()
            finish()
        }
    }


    private fun chked(img : ConstraintLayout, chkedNum: Int){
        img.setOnClickListener {
            RequestWritingThemeData.themeImgIdx = chkedNum
            themeImgIdx = chkedNum

            activity_writing_theme_CL_warning2.visibility = View.GONE
            activity_writing_theme_img_chk1.visibility = View.GONE
            activity_writing_theme_img_chk2.visibility = View.GONE
            activity_writing_theme_img_chk3.visibility = View.GONE
            activity_writing_theme_img_chk4.visibility = View.GONE
            activity_writing_theme_img_chk5.visibility = View.GONE
            activity_writing_theme_img_chk6.visibility = View.GONE
            activity_writing_theme_img_chk7.visibility = View.GONE
            activity_writing_theme_img_chk8.visibility = View.GONE
            activity_writing_theme_img_chk9.visibility = View.GONE
            activity_writing_theme_img_chk10.visibility = View.GONE
            activity_writing_theme_img_chk11.visibility = View.GONE
            activity_writing_theme_img_chk12.visibility = View.GONE
            activity_writing_theme_img_chk13.visibility = View.GONE
            activity_writing_theme_img_chk14.visibility = View.GONE
            activity_writing_theme_img_chk15.visibility = View.GONE
            activity_writing_theme_img_chk16.visibility = View.GONE
            when(img){
                activity_writing_theme_CL_img1 -> activity_writing_theme_img_chk1.visibility = View.VISIBLE
                activity_writing_theme_CL_img2 -> activity_writing_theme_img_chk2.visibility = View.VISIBLE
                activity_writing_theme_CL_img3 -> activity_writing_theme_img_chk3.visibility = View.VISIBLE
                activity_writing_theme_CL_img4 -> activity_writing_theme_img_chk4.visibility = View.VISIBLE
                activity_writing_theme_CL_img5 -> activity_writing_theme_img_chk5.visibility = View.VISIBLE
                activity_writing_theme_CL_img6 -> activity_writing_theme_img_chk6.visibility = View.VISIBLE
                activity_writing_theme_CL_img7 -> activity_writing_theme_img_chk7.visibility = View.VISIBLE
                activity_writing_theme_CL_img8 -> activity_writing_theme_img_chk8.visibility = View.VISIBLE
                activity_writing_theme_CL_img9 -> activity_writing_theme_img_chk9.visibility = View.VISIBLE
                activity_writing_theme_CL_img10 -> activity_writing_theme_img_chk10.visibility = View.VISIBLE
                activity_writing_theme_CL_img11 -> activity_writing_theme_img_chk11.visibility = View.VISIBLE
                activity_writing_theme_CL_img12 -> activity_writing_theme_img_chk12.visibility = View.VISIBLE
                activity_writing_theme_CL_img13 -> activity_writing_theme_img_chk13.visibility = View.VISIBLE
                activity_writing_theme_CL_img14 -> activity_writing_theme_img_chk14.visibility = View.VISIBLE
                activity_writing_theme_CL_img15 -> activity_writing_theme_img_chk15.visibility = View.VISIBLE
                activity_writing_theme_CL_img16 -> activity_writing_theme_img_chk16.visibility = View.VISIBLE
            }
        }

    }


    private fun requestData(){
        val call: Call<ResponseWritingThemeData> = RequestToServer.service.RequestWritingTheme(token = SharedPreferenceController.getAccessToken(context = this), body = RequestWritingThemeData)
        call.enqueue(object : Callback<ResponseWritingThemeData>{
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
                        Log.e("ResponseWritingThemeData 통신응답바디", "status: ${body!!.status} data : ${body!!.message}")
                    }
                }else{
                    response.body().let { body ->
                        Log.e("ResponseWritingThemeData 통신응답바디", "status: ${body!!.status} data : ${body!!.message}")
                    }
                }

            }

        })
    }

    private fun requestThemeImgData(){
        val call: Call<ResponseThemeImgData> = RequestToServer.service.GetPostThemeImg()
        call.enqueue(object : Callback<ResponseThemeImgData>{
            @SuppressLint("LongLogTag")
            override fun onFailure(call: Call<ResponseThemeImgData>, t: Throwable) {
                Log.e("ResponseWritingThemeData 통신실패",t.toString())
            }
            @SuppressLint("LongLogTag")
            override fun onResponse(
                call: Call<ResponseThemeImgData>,
                response: Response<ResponseThemeImgData>
            ) {
                if (response.isSuccessful){
                    response.body().let { body ->
                        Imgdatas = body!!.data

                        imgDataList[1] = imgData(Imgdatas.get(0).img, 1)
                        imgDataList[2] = imgData(Imgdatas.get(0).img, 2)
                        imgDataList[3] = imgData(Imgdatas.get(0).img, 3)
                        imgDataList[4] = imgData(Imgdatas.get(0).img, 4)
                        imgDataList[5] = imgData(Imgdatas.get(0).img, 5)
                        imgDataList[6] = imgData(Imgdatas.get(0).img, 6)
                        imgDataList[7] = imgData(Imgdatas.get(0).img, 7)
                        imgDataList[8] = imgData(Imgdatas.get(0).img, 8)
                        imgDataList[9] = imgData(Imgdatas.get(0).img, 9)
                        imgDataList[10] = imgData(Imgdatas.get(0).img, 10)
                        imgDataList[11] = imgData(Imgdatas.get(0).img, 11)
                        imgDataList[12] = imgData(Imgdatas.get(0).img, 12)
                        imgDataList[13] = imgData(Imgdatas.get(0).img, 13)
                        imgDataList[14] = imgData(Imgdatas.get(0).img, 14)
                        imgDataList[15] = imgData(Imgdatas.get(0).img, 15)
                        imgDataList[16] = imgData(Imgdatas.get(0).img, 16)

                    }
                }

            }

        })
    }



}


