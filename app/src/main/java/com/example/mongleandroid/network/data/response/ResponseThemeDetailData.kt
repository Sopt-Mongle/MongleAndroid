package com.example.mongleandroid.network.data.response

data class ResponseThemeDetailData(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : ThemeDetailData?
)

data class ThemeDetailData(
    val theme : List<DataTheme>,
    val sentence : List<DataSentence>
)
data class DataTheme(
    val themeIdx : Int,
    val theme : String,
    val themeImg : String,
    val saves : Int,
    val writer : String,
    val writerImg : String,
    val alreadyBookmarked : Boolean,
    val sentenceNum : Int
)

data class DataSentence(
    val sentenceIdx : Int,
    val sentence : String,
    val likes : Int,
    val saves : Int,
    val writer : String,
    val writerImg : String,
    val title : String,
    val author : String,
    val publisher : String,
    val timestamp : String,
    val alreadyLiked : Boolean,
    val alreadyBookmarked : Boolean
)