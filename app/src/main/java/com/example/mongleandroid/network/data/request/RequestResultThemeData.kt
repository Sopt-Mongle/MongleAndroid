package com.example.mongleandroid.network.data.request

data class RequestResultThemeData (
    val curatorIdx : String, // 현재 사용자 Idx
    val words : String //검색어(띄어쓰기 있어도 그냥 한번에 보내주세요)
)