package com.example.mongleandroid

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout

fun goNextView(current : View, next : View){
    current.visibility = View.GONE
    next.visibility = View.VISIBLE
}
fun goPrevView(current: View, prev : View) {
    current.visibility = View.GONE
    prev.visibility = View.VISIBLE
}
fun goNextPage(current : ConstraintLayout, next : ConstraintLayout){
    current.visibility = View.GONE
    next.visibility = View.VISIBLE
}
fun goPrevPage(current: ConstraintLayout, prev : ConstraintLayout){
    current.visibility = View.GONE
    prev.visibility = View.VISIBLE
}
