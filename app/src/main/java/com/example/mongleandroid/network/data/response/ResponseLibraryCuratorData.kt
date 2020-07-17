package com.example.mongleandroid.network.data.response

data class ResponseLibraryCuratorData (
    val status : Int,
    val success : Boolean,
    val data : List<LibraryCurator>
)

data class LibraryCurator (
    val curatorIdx : Int, //나의 큐레이터 인덱스
    val name : String, //나의 큐레이터 이름
    val img : String, //나의 프로필사진
    val introduce : String, //나의 큐레이터 소개 줄글
    val keyword : String, //나의 큐레이터 소개 키워드
    val subscribe : Int, //나를 구독하는 사람 수
    val alreadySubscribed : Boolean
)