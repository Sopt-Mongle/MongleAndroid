package com.example.mongleandroid.activity

import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.mongleandroid.R
import com.example.mongleandroid.fragment.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_curator.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_mypage.*
import kotlinx.android.synthetic.main.fragment_search.*


class MainActivity : AppCompatActivity() {

    companion object{
        var search_result = ""
    }

    private var isFabOpen = false
    lateinit var fab_open: Animation
    lateinit var fab_close: Animation


    //fragment 처리 객체
    lateinit var mainFragment: MainFragment
    lateinit var searchFragment: SearchFragment
    lateinit var curatorFragment: CuratorFragment
    lateinit var libraryFragment: LibraryFragment



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_activity_FAB_st.visibility = GONE
        main_activity_FAB_tm.visibility = GONE
        fab_open = AnimationUtils.loadAnimation(this,
            R.anim.fab_open
        );
        fab_close = AnimationUtils.loadAnimation(this,
            R.anim.fab_close
        );

        main_activity_bnv.bringToFront()
        main_activity_FAB_main.bringToFront()


        main_activity_FAB_main.setOnClickListener {
            toggleFab()
        }



        //fragment 객체 초기화
        mainFragment = MainFragment()
        searchFragment = SearchFragment()
        curatorFragment = CuratorFragment()
        libraryFragment = LibraryFragment()

        supportFragmentManager.beginTransaction().replace(R.id.main_activity_fg, mainFragment).commit()

        main_activity_bnv.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.menu_main -> supportFragmentManager.beginTransaction().replace(R.id.main_activity_fg, mainFragment).commit()
                R.id.menu_search ->
                {
                    supportFragmentManager.beginTransaction().replace(R.id.main_activity_fg, searchFragment).commit()
                    //search_fragment_et_search.requestFocus()
                }
                R.id.menu_curator -> supportFragmentManager.beginTransaction().replace(R.id.main_activity_fg, curatorFragment).commit()
                R.id.menu_mypage -> supportFragmentManager.beginTransaction().replace(R.id.main_activity_fg, libraryFragment).commit()
            }
            true
        }



    }

    private fun toggleFab() {
        if (isFabOpen) {
            main_activity_FAB_tm.startAnimation(fab_close)
            main_activity_FAB_st.startAnimation(fab_close)
            ObjectAnimator.ofFloat(main_activity_FAB_tm, "translationY", 0f).apply { start() }
            ObjectAnimator.ofFloat(main_activity_FAB_st, "translationY", 0f).apply { start() }
            main_activity_FAB_main.setImageResource(R.drawable.ic_add)

            main_activity_blur.visibility = GONE


        } else {
            main_activity_FAB_tm.startAnimation(fab_open)
            main_activity_FAB_st.startAnimation(fab_open)
            main_activity_FAB_st.visibility = VISIBLE
            main_activity_FAB_tm.visibility = VISIBLE
            ObjectAnimator.ofFloat(main_activity_FAB_tm, "translationY", -250f).apply { start() }
            ObjectAnimator.ofFloat(main_activity_FAB_st, "translationY", -400f).apply { start() }
            main_activity_FAB_main.setImageResource(R.drawable.ic_close)

            main_activity_blur.visibility = VISIBLE
            //main_activity_fg.setOnTouchListener { v, event ->  }

            main_activity_FAB_st.setOnClickListener {
                val intent = Intent(this@MainActivity,WritingSentenceActivity::class.java)
                startActivity(intent)
            }

            main_activity_FAB_tm.setOnClickListener {
                val intent = Intent(this@MainActivity,WritingThemeActivity::class.java)
                startActivity(intent)
            }

        }

        isFabOpen = !isFabOpen
    }
    


}
