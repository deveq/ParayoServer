package com.example.parayo.controller

import com.example.parayo.FcmReqModel
import com.example.parayo.common.ApiResponse
import com.example.parayo.fcm.NotificationService
import org.springframework.web.bind.annotation.*

// RestController :  스프링에서 HTTP 호출의 응답으로 뷰를 렌더링 하지 않고
// HTTP 본문에 직접 텍스트로 이루어진 데이터를 쓴다는 의미
@RestController
class HelloApiController {

    // HTTP의 GET 메서드를 통해 해당 함수를 실행하고 해당 반환값을 돌려준다는 의미.
    // ApiResponse는 data class이므로 toString으로 바로 출력됨 (JSON으로)
    // data는 "world"임. ApiReponse.ok이니까 success는 true, data는 "world", message는 null
    @GetMapping("/api/v1/hello")
    fun hello() = ApiResponse.ok("world")

    @GetMapping("/fcm")
    fun getFcm(@RequestParam id: String) = ApiResponse.ok(id)

    @PostMapping("/fcm"/*, produces = ["application-json"]*/)
    fun getPostFcm(@RequestBody req: FcmReqModel): String {
        println("title : ${req.title} , content : ${req.content}")
        return NotificationService.sendToUser2(req.token, req.title, req.content)
    }

}
