package com.example.mongleandroid.network.data.response

data class ResponseSearchRecentData (
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : List<String>
)

