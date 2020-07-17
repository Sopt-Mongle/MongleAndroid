package com.example.mongleandroid.network.data.response

data class ResponseJoinData (
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : Join
)
data class Join(
    val accessToken : String
)