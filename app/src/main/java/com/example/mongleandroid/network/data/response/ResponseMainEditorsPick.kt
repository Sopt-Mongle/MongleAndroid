package com.example.mongleandroid.network.data.response

data class ResponseMainEditorsPick(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : List<MainEditorPick>
)
data class MainEditorPick(
    val editorpickIdx : Int,
    val illust : String,
    val themeIdx : Int,
    val sentenceNum : Int
)