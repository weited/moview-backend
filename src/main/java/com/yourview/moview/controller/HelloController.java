package com.yourview.moview.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// only for test, will be removed later

@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping
    public String index() {
        return "Hello, this is moview api!";
    }
}
