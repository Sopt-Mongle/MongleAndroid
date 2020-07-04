package com.example.mongleandroid

import android.animation.ObjectAnimator
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.*
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var isFabOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_activity_FAB_st.visibility = GONE
        main_activity_FAB_tm.visibility = GONE

        main_activity_BAB.bringToFront()
        main_activity_FAB_main.bringToFront()

        main_activity_FAB_main.setOnClickListener {
            toggleFab()
        }

    }

    private fun toggleFab() {
        if (isFabOpen) {
            ObjectAnimator.ofFloat(main_activity_FAB_tm, "translationY", 0f).apply { start() }
            ObjectAnimator.ofFloat(main_activity_FAB_st, "translationY", 0f).apply { start() }
            main_activity_FAB_main.setImageResource(R.drawable.ic_add)
            main_activity_CL.setBackgroundColor(Color.parseColor("#00000000"));
        } else {
            main_activity_FAB_st.visibility = VISIBLE
            main_activity_FAB_tm.visibility = VISIBLE
            ObjectAnimator.ofFloat(main_activity_FAB_tm, "translationY", -250f).apply { start() }
            ObjectAnimator.ofFloat(main_activity_FAB_st, "translationY", -400f).apply { start() }
            main_activity_FAB_main.setImageResource(R.drawable.ic_close)
            main_activity_CL.setBackgroundColor(Color.parseColor("#59000000"));
        }

        isFabOpen = !isFabOpen
    }
}
