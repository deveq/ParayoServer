package com.example.parayo.common

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController


@ControllerAdvice //스프링에게 이 클래스가 전역적인 익셉션 핸들러임을 알려줌
@RestController
class ParayoExceptionHandler {

    private val logger = LoggerFactory.getLogger(this::class.java)

    //ExceptionHandler는 괄호 안에 있는 클래스에 대한 타입의 예외 처리를 할것이라 알려줌
    @ExceptionHandler(ParayoException::class)
    fun handleParayoException(e: ParayoException) : ApiResponse {
        logger.error("API error", e)
        return ApiResponse.error(e.message)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception) : ApiResponse {
        logger.error("API error", e)
        return ApiResponse.error("알 수 없는 오류가 발생했습니다.")
    }

}