package com.example.mongleandroid.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mongleandroid.R
import com.example.mongleandroid.adapter.WritingThemeAdapter
import com.example.mongleandroid.goNextPage
import com.example.mongleandroid.goPrevPage
import kotlinx.android.synthetic.main.activity_writing_theme.*
import kotlinx.android.synthetic.main.item_writng_theme.*
import kotlin.properties.Delegates

class WritingThemeActivity : AppCompatActivity() {

    lateinit var writingThemeAdapter: WritingThemeAdapter
    var datas: MutableList<Int> = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing_theme)


        //등록하기 버튼
        activity_theme_writing_sentence_btn_upload.setOnClickListener {
            goNextPage(activity_writing_theme_CL_noPopUp, activity_writing_theme_CL_popup)
        }

        //뒤로가기 버튼
        activity_writing_theme_btn_out.setOnClickListener {
            finish()
            //goNextPage(activity_writing_theme_CL_noPopUp, activity_writing_theme_CL_popup)

        }
        //팝업 끄기 버튼
        activity_writing_theme_btn_out_blur.setOnClickListener {
            goPrevPage(activity_writing_theme_CL_popup,activity_writing_theme_CL_noPopUp)
        }

        //팝업에서 네 버튼
        // goNextPage(activity_writing_theme_CL_popup, activity_writing_theme_CL_finish)
        //팝업에서 아니요 버튼
        // goNextPage(activity_writing_theme_CL_popup, activity_writing_theme_CL_noPopUp)

        //키보드 제어
        //애니메이션
        //에러 메세지

        writingThemeAdapter = WritingThemeAdapter(this)
        activity_writing_theme_rv.adapter = writingThemeAdapter
        //activity_writing_theme_rv.addItemDecoration(ItemDecoration())
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


