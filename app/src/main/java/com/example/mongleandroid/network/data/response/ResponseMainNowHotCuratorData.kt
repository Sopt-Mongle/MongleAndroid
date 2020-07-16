package com.example.mongleandroid.network.data.response

data class ResponseMainNowHotData(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : List<MainCurator>
)

data class MainCurator(
    val curatorIdx : Int, //큐레이터 idx
    val name : String,  //큐레이터 이름
    val img : String,  //큐레이터 프로필 이미지
    val introduce : String, //큐레이터 소개 줄글
    val keyword : String, //큐레이터 키워드
    val keywordIdx : Int, //큐레이터 키워드 idx
    val subscribe : Int //큐레이터의 구독자 수
)