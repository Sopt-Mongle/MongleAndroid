package com.example.mongleandroid.util

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mongleandroid.R
import com.example.mongleandroid.activity.JoinActivity
import com.example.mongleandroid.activity.WritingThemeFinishActivity
import com.example.mongleandroid.goNextPage
import com.example.mongleandroid.unshowKeyboard
import kotlinx.android.synthetic.main.activity_writing_theme.*

class DialogMakethemeCheck(context : Context) {
    private val dlg = Dialog(context)   //부모 액티비티의 context 가 들어감
    private lateinit var maketheme_popup_title : TextView
    private lateinit var maketheme_popup_yes : TextView
    private lateinit var maketheme_popup_no : TextView
    private lateinit var listener : MyDialogOKClickedListener
    lateinit var themeImg : MutableList<Int>


    fun start(chkedNum : Int){
        themeImg.add(R.drawable.maketheme_img_theme_1)
        themeImg.add(R.drawable.maketheme_img_theme_1)
        themeImg.add(R.drawable.maketheme_img_theme_1)
        themeImg.add(R.drawable.maketheme_img_theme_1)
        themeImg.add(R.drawable.maketheme_img_theme_1)
        themeImg.add(R.drawable.maketheme_img_theme_1)
        themeImg.add(R.drawable.maketheme_img_theme_1)
        themeImg.add(R.drawable.maketheme_img_theme_1)
        themeImg.add(R.drawable.maketheme_img_theme_1)
        themeImg.add(R.drawable.maketheme_img_theme_1)
        themeImg.add(R.drawable.maketheme_img_theme_1)
        themeImg.add(R.drawable.maketheme_img_theme_1)
        themeImg.add(R.drawable.maketheme_img_theme_1)
        themeImg.add(R.drawable.maketheme_img_theme_1)
        themeImg.add(R.drawable.maketheme_img_theme_1)

        when(chkedNum){
            1 -> maketheme_popup_title.setBackgroundResource(R.drawable.maketheme_check_img_theme)
            2 -> themeImg.add(R.drawable.maketheme_img_theme_1)
            3 -> themeImg.add(R.drawable.maketheme_img_theme_1)
            4 -> themeImg.add(R.drawable.maketheme_img_theme_1)
            5 -> themeImg.add(R.drawable.maketheme_img_theme_1)
            6 -> themeImg.add(R.drawable.maketheme_img_theme_1)
            7 -> themeImg.add(R.drawable.maketheme_img_theme_1)
            8 -> themeImg.add(R.drawable.maketheme_img_theme_1)
            9 -> themeImg.add(R.drawable.maketheme_img_theme_1)
            10 -> themeImg.add(R.drawable.maketheme_img_theme_1)
            11 -> themeImg.add(R.drawable.maketheme_img_theme_1)
            12 -> themeImg.add(R.drawable.maketheme_img_theme_1)
            13 -> themeImg.add(R.drawable.maketheme_img_theme_1)
            14 -> themeImg.add(R.drawable.maketheme_img_theme_1)
            15 -> themeImg.add(R.drawable.maketheme_img_theme_1)
            16 -> themeImg.add(R.drawable.maketheme_img_theme_1)
        }




        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)   //타이틀바 제거
        dlg.setCancelable(false)    //다이얼로그의 바깥 화면을 눌렀을 때 다이얼로그가 닫히지 않도록 함
        dlg.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dlg.setContentView(R.layout.dialog_maketheme_check)     //다이얼로그에 사용할 xml 파일을 불러옴

        maketheme_popup_yes = dlg.findViewById(R.id.maketheme_popup_yes)
        maketheme_popup_yes.setOnClickListener{
            //돌아갈 액티비티
            val intent = Intent(it.context, WritingThemeFinishActivity::class.java)
            it.context.startActivity(intent)
            dlg.dismiss()
        }

        maketheme_popup_no = dlg.findViewById(R.id.maketheme_popup_no)
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

}
