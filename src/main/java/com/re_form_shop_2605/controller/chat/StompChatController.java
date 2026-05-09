package com.re_form_shop_2605.controller.chat;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Log4j2
@Controller
@RequiredArgsConstructor
public class StompChatController {
    /* STOMP 프로토콜을 사용한 웹소켓 메시지 처리를 담당하는 컨트롤러 */

    @MessageMapping("/chat")
    @SendTo("/sub/shat")
    public String handleMessage(String message){
        log.info("Received chat message: {}", message);
        return message;
    }
}
