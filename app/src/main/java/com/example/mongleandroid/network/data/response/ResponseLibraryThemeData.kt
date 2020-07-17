package com.example.mongleandroid.network.data.response

data class ResponseLibraryThemeData (
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : LibraryTheme?
)

data class LibraryTheme (
    val write : List<LibraryThemeWrite>,
    val save : List<LibraryThemeSave>
)

data class LibraryThemeWrite (
    val themeIdx : Int,
    val theme : String,
    val saves : Int,
    val sentenceNum : Int
)

data class LibraryThemeSave (
    val themeIdx: Int,
    val theme : String,
    val saves : Int,
    val sentenceNum: Int
)