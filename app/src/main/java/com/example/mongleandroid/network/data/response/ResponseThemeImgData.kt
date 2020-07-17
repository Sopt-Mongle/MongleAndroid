package com.example.mongleandroid.network.data.response

data class ResponseThemeImgData (
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : MutableList<ImgData>

)

data class ImgData(
    var themeImgIdx : Int,
    var img: String
)