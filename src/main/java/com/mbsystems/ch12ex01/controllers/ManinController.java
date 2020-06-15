package com.mbsystems.ch12ex01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManinController {

    @GetMapping( "/" )
    public String main() {
        return "main.html";
    }
}
