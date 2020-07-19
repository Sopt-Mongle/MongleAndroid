package com.example.mongleandroid.util

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.TextView
import com.example.mongleandroid.R


class DialogSentenceDelete(context : Context) {
    private val dlg = Dialog(context)   //부모 액티비티의 context 가 들어감
    private lateinit var delete_popup_ok : TextView
    private lateinit var delete_popup_no : TextView
    private lateinit var listener : MyDialogOKClickedListener


    fun start(content : String) {
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)   //타이틀바 제거
        dlg.setCancelable(false)    //다이얼로그의 바깥 화면을 눌렀을 때 다이얼로그가 닫히지 않도록 함
        dlg.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dlg.setContentView(R.layout.dialog_login)     //다이얼로그에 사용할 xml 파일을 불러옴

        delete_popup_no = dlg.findViewById(R.id.delete_popup_no)
        delete_popup_no.setOnClickListener {
            dlg.dismiss()
        }

        // 삭제하는 경우
        delete_popup_ok = dlg.findViewById(R.id.delete_popup_ok)
        delete_popup_ok.setOnClickListener {
            // 나중에 플로우 연결하면서 테스트 예정 (현진)
            // (it.context as Activity).finish()
//            val intent = Intent(it.context, JoinActivity::class.java)
//            it.context.startActivity(intent)
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
