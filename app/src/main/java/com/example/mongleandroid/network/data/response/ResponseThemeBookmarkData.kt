package com.example.mongleandroid.network.data.response

data class ResponseThemeBookmarkData (
    var status : Int,
    var success : Boolean,
    var message : String,
    var data : SavedData?
)

data class SavedData (
    var isSave : Boolean,
    var saves : Int
)