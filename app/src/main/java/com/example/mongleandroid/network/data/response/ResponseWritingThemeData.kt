package com.example.mongleandroid.network.data.response

data class ResponseWritingThemeData (
    var staus : Int,
    var success : Boolean,
    var message : String
) {
    lateinit var status: String
}