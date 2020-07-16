package com.example.mongleandroid.network.data

data class ResponseMainHotThemeData(
    val status: Int,
    val success : Boolean,
    val message : String,
    val data: MainThemes
)
data class MainThemes(
    val themeIdx : Int,
    val theme : String,
    val themeImg : String,
    val saves : Int,
    val alreadyBookmarked : Boolean,
    val sentenceNum : Int
)