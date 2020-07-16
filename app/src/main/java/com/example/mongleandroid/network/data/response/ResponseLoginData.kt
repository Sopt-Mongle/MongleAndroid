package com.example.mongleandroid.network.data.response

data class ResponseLoginData (
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : Login
)
data class Login(
    val accessToken : String
)



