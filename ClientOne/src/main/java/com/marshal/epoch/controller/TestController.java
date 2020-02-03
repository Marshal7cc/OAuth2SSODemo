package com.marshal.epoch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auth: Marshal
 * @date: 2020/2/3
 * @desc:
 */
@RestController
public class TestController {

    @GetMapping("/index")
    public String test() {
        return "client1";
    }
}
