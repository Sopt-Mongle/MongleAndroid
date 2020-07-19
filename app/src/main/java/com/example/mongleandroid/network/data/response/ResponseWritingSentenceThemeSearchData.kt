package com.example.mongleandroid.network.data.response

data class ResponseWritingSentenceThemeSearchData (
    val staus : Int,
    val success : Boolean,
    val message : String,
    val data : MutableList<ThemeData>
)


data class ThemeData(
    val themeIdx : Int,
    val theme : String,
    val themeImg : String,
    val themeImgIdx : Int,
    val saves : Int,
    val writer: String,
    val writerImg : String,
    val alreadyBookmarked : Boolean
)
