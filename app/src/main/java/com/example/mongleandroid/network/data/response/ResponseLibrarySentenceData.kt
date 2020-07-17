package com.example.mongleandroid.network.data.response

data class ResponseLibrarySentenceData (
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : LibrarySentence?
)

data class LibrarySentence (
    val write : List<LibrarySentenceWrite>,
    val save : List<LibrarySentenceSave>
)

data class LibrarySentenceWrite (
    val sentenceIdx : Int,
    val sentence : String,
    val theme : String,
    val likes : Int,
    val saves : Int,
    val writer : String,
    val title : String,
    val author : String,
    val publisher : String,
    val timestamp : String
)

data class LibrarySentenceSave (
    val sentenceIdx : Int,
    val sentence : String,
    val theme : String,
    val likes : Int,
    val saves : Int,
    val writer : String,
    val title : String,
    val author : String,
    val publisher : String,
    val timestamp : String
)