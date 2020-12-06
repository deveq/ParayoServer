package com.example.parayo.common

import com.example.parayo.fcm.NotificationService

data class ApiResponse(
    val success: Boolean,
    val data: Any? = null,
    val message: String? = null
) {
    /*
    * ApiResponse의 생성자에 바로 값을 넣어서 실패와 성공 여부를 만들수도 있지만
    * 보다 명료하게 ApiResponse.ok(데이터), ApiResponse.error(메세지)로 사용할 수 있음.
    * */

    companion object {
        fun ok(data: Any? = null) = ApiResponse(true, data)
        fun error(message: String? = null) =
            ApiResponse(false, message = message)
//        fun push(token: String, title: String, content: String) : String {
//            NotificationService().sendToUser2(token, title, content)
//            return "성공"
//        }
    }
}