package com.example.mongleandroid.network.data.response

data class ResponseCuratorKeywordData (
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : MutableList<CuratorKeyword>
)

data class CuratorKeyword(
    val curatorIdx : Int,// 큐레이터 idx
    val name : String, // 큐레이터 이름
    val img	: String, // 큐레이터 프로필 이미지
    val introduce : String, // 소개 줄글
    val keyword	: String, // 큐레이터 키워드 배열
    val subscribe : Int, // 검색된 큐레이터 구독자 수
    val alreadySubscribed : Boolean
)