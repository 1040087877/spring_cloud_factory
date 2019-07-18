package com;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index(@RequestParam String name) throws InterruptedException {
        System.out.println("request two name is "+name);
        Thread.sleep(10000);
        return "hello2"+name+",this is two message";
    }
}
