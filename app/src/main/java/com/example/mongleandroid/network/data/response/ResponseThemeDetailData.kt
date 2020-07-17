package com.example.mongleandroid.network.data.response

data class ResponseThemeDetailData(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : List<ThemeDetailData>
)
data class ThemeDetailData(
    val themeIdx : Int,
    val theme : String,
    val themeImg : String,
    val saves : Int,
    val writer : String,
    val writerImg : String,
    val alreadyBookmarked : Boolean,
    val sentenceNum : Int
)
