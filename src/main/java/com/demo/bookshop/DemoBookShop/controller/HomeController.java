package com.demo.bookshop.DemoBookShop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String getString(){
        return "Hi There!!";
    }

}
