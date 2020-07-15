package com.example.mongleandroid.network.data.request

data class RequestJoinData (
    val email : String, // 회원가입할 이메일 주소
    val password : String, // 회원가입할 비밀번호
    val name : String // 회원가입할 이름(닉네임)
)