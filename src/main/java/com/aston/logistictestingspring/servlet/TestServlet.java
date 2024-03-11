package com.aston.logistictestingspring.servlet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestServlet {
    @GetMapping
    public String test() {
        return "Hello world";
    }
}
