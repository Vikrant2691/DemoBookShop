package com.demo.bookshop.DemoBookShop.controller;

import com.demo.bookshop.DemoBookShop.properties.ServiceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final ServiceProperties serviceProperties;

    public HomeController(ServiceProperties serviceProperties) {
        this.serviceProperties = serviceProperties;
    }

    @GetMapping("/")
    public String getString(){
        return "Hi There!!";
    }

    @GetMapping("/greetings")
    public String getGreetings(){
        return serviceProperties.getGreeting();
    }



}
