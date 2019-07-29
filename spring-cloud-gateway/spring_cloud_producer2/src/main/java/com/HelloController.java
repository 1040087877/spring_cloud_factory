package com;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index(@RequestParam String name) throws InterruptedException {
        System.out.println("the name is " + name);
        if ("retry".equals(name)) {
            //TimeUnit.SECONDS.sleep(10);
            throw new NumberFormatException();
        }
        return "hello"+name+",this is two message";
    }
    @RequestMapping("/foo")
    public String foo(String foo) {
        return "hello two "+foo+"!!";
    }
}
