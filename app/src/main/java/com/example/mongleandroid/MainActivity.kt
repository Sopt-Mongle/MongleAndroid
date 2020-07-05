package com.example.mongleandroid

import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var isFabOpen = false
    lateinit var fab_open: Animation
    lateinit var fab_close: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_activity_FAB_st.visibility = GONE
        main_activity_FAB_tm.visibility = GONE
        fab_open = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(this, R.anim.fab_close);

        main_activity_bnv.bringToFront()
        main_activity_FAB_main.bringToFront()


        main_activity_FAB_main.setOnClickListener {
            toggleFab()
        }


//        val fm: FragmentManager = supportFragmentManager
//        val fragmentTransaction: FragmentTransaction = fm.beginTransaction()
//        fragmentTransaction.add(R.id.main_activity_fg, MainFragment())
//
//
//
//
//        main_activity_bnv.setOnNavigationItemSelectedListener {
//            when(it.itemId){
//                R.id.menu_main -> 0
//                R.id.menu_search -> 1
//                R.id.menu_curator -> 2
//                R.id.menu_mypage -> 3
//            }
//            true
//        }
//



    }

    private fun toggleFab() {
        if (isFabOpen) {
            main_activity_FAB_tm.startAnimation(fab_close)
            main_activity_FAB_st.startAnimation(fab_close)
            ObjectAnimator.ofFloat(main_activity_FAB_tm, "translationY", 0f).apply { start() }
            ObjectAnimator.ofFloat(main_activity_FAB_st, "translationY", 0f).apply { start() }
            main_activity_FAB_main.setImageResource(R.drawable.ic_add)
            main_activity_CL.setBackgroundColor(Color.parseColor("#00000000"));

        } else {
            main_activity_FAB_tm.startAnimation(fab_open)
            main_activity_FAB_st.startAnimation(fab_open)
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
