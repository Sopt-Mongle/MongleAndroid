package com.example.mongleandroid.network.data.response

data class ResponseResultCuratorData (
    //val curatorIdx : Int,// 검색된 큐레이터 idx
    val name : String, // 검색된 큐레이터 이름
    val img	: String, // 검색된 큐레이터 프로필 이미지
    val keyword	: String, // 검색된 큐레이터 키워드 배열
    val subscribe : String // 검색된 큐레이터 구독자 수
)