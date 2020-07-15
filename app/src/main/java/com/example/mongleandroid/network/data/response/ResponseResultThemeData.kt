package com.example.mongleandroid.network.data.response

data class ResponseResultThemeData (
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : List<ResultTheme>
)

data class ResultTheme(
    val themeIdx : Int, // 테마 고유 idx
    val theme : String, // 테마 이름
    val saves : Int, // 테마 북마크 수
    val sentenceNum	: Int // 테마 안에 속한 문장 개수
)