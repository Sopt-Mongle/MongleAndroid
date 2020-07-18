package com.example.mongleandroid.network.data.response

data class ResponseNoThemeData (
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : NoTheme?
)

data class NoTheme (
    val num : Int,
    val sentences : List<NoThemeSentence>
)

data class NoThemeSentence (
    val sentenceIdx : Int,
    val sentence : String,
    val title : String,
    val author : String,
    val publisher : String,
    val timestamp : String
)