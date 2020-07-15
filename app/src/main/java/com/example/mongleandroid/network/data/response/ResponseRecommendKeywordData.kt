package com.example.mongleandroid.network.data.response

data class ResponseRecommendKeywordData (
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : List<Any>
)
