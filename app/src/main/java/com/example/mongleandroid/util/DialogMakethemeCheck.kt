package com.example.mongleandroid.util

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.TextView
import com.example.mongleandroid.R
import com.example.mongleandroid.activity.JoinActivity
import com.example.mongleandroid.activity.LoginActivity

class DialogMakethemeCheck(context : Context) {
    private val dlg = Dialog(context)   //부모 액티비티의 context 가 들어감
    private lateinit var maketheme_popup_title : TextView
    private lateinit var maketheme_popup_yes : TextView
    private lateinit var maketheme_popup_no : TextView
    private lateinit var listener : MyDialogOKClickedListener


    fun start(content : String) {
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)   //타이틀바 제거
        dlg.setCancelable(false)    //다이얼로그의 바깥 화면을 눌렀을 때 다이얼로그가 닫히지 않도록 함
        dlg.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dlg.setContentView(R.layout.dialog_maketheme_check)     //다이얼로그에 사용할 xml 파일을 불러옴

        maketheme_popup_yes = dlg.findViewById(R.id.maketheme_popup_yes)
        maketheme_popup_yes.setOnClickListener {
            // 세란아 여기 테마등록완료 액티비티명 등록하면돼 일단 임의로 MakeThemeFinishActivity ..
//            val intent = Intent(it.context, MakeThemeFinishActivity::class.java)
//            it.context.startActivity(intent)
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
