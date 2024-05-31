package com.jdc.stomp.api;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringMessageApi {

    @SubscribeMapping("/hello")
    public String subscribe() {
        return "Success";
    }

    @MessageMapping("/hello")
    public String send(String message) {
        return "This is Response >>> Success , and your message is : " + message;
    }

}
