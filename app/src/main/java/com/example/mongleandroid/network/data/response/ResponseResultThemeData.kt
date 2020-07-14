package com.example.mongleandroid.network.data.response

data class ResponseResultThemeData (
    //val themeIdx : Int // 테마 고유 idx
    val theme : String, // 테마 이름
    val saves : String, // 테마 북마크 수
    val sentenceNum	: String // 테마 안에 속한 문장 개수
)