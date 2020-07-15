package com.example.mongleandroid

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

fun EditText.showKeyboard() {
    if (requestFocus()) {
        // edittext에 초점이 맞춰지면 키보드 올라옴
        (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
        setSelection(text.length)
    }
}

fun EditText.unshowKeyboard() {
    if (requestFocus()) {
        // edittext에 초점이 맞춰지면 키보드 올라옴
        (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .hideSoftInputFromWindow(this.windowToken, 0)
        setSelection(text.length)
    }
}