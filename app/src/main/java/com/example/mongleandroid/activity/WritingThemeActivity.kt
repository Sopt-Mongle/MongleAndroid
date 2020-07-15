package com.example.mongleandroid.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.mongleandroid.*
import com.example.mongleandroid.adapter.WritingThemeAdapter
import com.example.mongleandroid.util.DialogLogin
import com.example.mongleandroid.util.DialogMakethemeCheck
import kotlinx.android.synthetic.main.activity_writing_sentence.*
import kotlinx.android.synthetic.main.activity_writing_theme.*
import kotlinx.android.synthetic.main.dialog_maketheme_check.*
import kotlinx.android.synthetic.main.item_writng_theme.*
import kotlin.properties.Delegates

class WritingThemeActivity : AppCompatActivity() {

    lateinit var writingThemeAdapter: WritingThemeAdapter
    var datas: MutableList<Int> = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing_theme)

        activity_writing_theme_et_theme_title.requestFocus()
        activity_writing_theme_et_theme_title.showKeyboard()


        activity_writing_theme_et_theme_title.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {


            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //activity_writing_theme_CL_nomal
                //activity_writing_theme_CL_warning
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
            }else{
                val dlg = DialogMakethemeCheck(this)
                dlg.setOnOKClickedListener{ content ->
                }
                dlg.start("")

                //키보드 제어
                activity_writing_theme_et_theme_title.unshowKeyboard()
            }


        }

        //뒤로가기 버튼
        activity_writing_theme_btn_out.setOnClickListener {
            Toast.makeText(this, "메인화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show()
            finish()
        }


        //키보드 제어
        //애니메이션
        //에러 메세지

        writingThemeAdapter = WritingThemeAdapter(this)
        activity_writing_theme_rv.adapter = writingThemeAdapter
        loadDatas()
    }
    private fun loadDatas(){
        datas.apply {
            add(
                R.drawable.maketheme_img_theme_1
            )
            add(
                R.drawable.maketheme_img_theme_2
            )
            add(
                R.drawable.maketheme_img_theme_1
            )
            add(
                R.drawable.maketheme_img_theme_2
            )
            add(
                R.drawable.maketheme_img_theme_1
            )
            add(
                R.drawable.maketheme_img_theme_2
            )
            add(
                R.drawable.maketheme_img_theme_1
            )
            add(
                R.drawable.maketheme_img_theme_2
            )
            add(
                R.drawable.maketheme_img_theme_1
            )
            add(
                R.drawable.maketheme_img_theme_2
            )
//            add(
//                R.drawable.maketheme_img_theme_3
//            )
//            add(
//                R.drawable.maketheme_img_theme_4
//            )
//            add(
//                R.drawable.maketheme_img_theme_5
//            )
//            add(
//                R.drawable.maketheme_img_theme_6
//            )
//            add(
//                R.drawable.maketheme_img_theme_7
//            )
//            add(
//                R.drawable.maketheme_img_theme_8
//            )
//            add(
//                R.drawable.maketheme_img_theme_9
//            )
//            add(
//                R.drawable.maketheme_img_theme_10
//            )


            writingThemeAdapter.datas = datas
            writingThemeAdapter.notifyDataSetChanged()

        }



    }

}


