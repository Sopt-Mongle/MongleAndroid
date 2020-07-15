package com.example.mongleandroid

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent

import androidx.viewpager.widget.ViewPager


class NonSwipeableViewPager : ViewPager {
    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {}

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        // 스와이핑되서 페이지가 바뀌는것을 막는다.
        return false
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        //스와이핑되서 페이가 바뀌는 것을 막는다.
        return false
    }
}