package com.example.mongleandroid.network.data.response

data class ResponseCuratorInThemeData (
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : CuratorInTheme?
)

data class CuratorInTheme(
    val themeIdx : Int, // 해당 테마 인덱스
    val theme : String, //해당 테마 이름
    val themeImgIdx : String, // 해당 테마 이미지 인덱스
    val saves : Int, // 해당 테마 북마크 수
    val writer : String, // 테마 작성자
    val writerImg : String, // 테마 작성자 프로필 사진
    val alreadyBookmarked : Boolean, // 현재 사용자가 이 테마를 저장한 상태(true: 저장됨, false: 저장되지 않음)
    val sentenceNum : Int, // 해당 테마 안에 있는 문장 개수
    val curators : List<CuratorList>
)

data class CuratorList(
    val curatorIdx : Int, // 검색된 큐레이터 idx
    val name : String, // 검색된 큐레이터 이름
    val img	: String, // 검색된 큐레이터 프로필 이미지
    val keyword	: String, // 검색된 큐레이터 키워드 배열
    val subscribe : Int, // 검색된 큐레이터 구독자 수
    val alreadySubscribed : Boolean
)