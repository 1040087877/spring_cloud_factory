package com.remote;

import org.springframework.stereotype.Component;

/**
 * @ClassName:
 * @Description: TODO
 * @author linyb3
 * @date
 *
 */
@Component
public class HelloRemoteHystrix implements HelloRemote{
    @Override
    public String hello(String name) {
        return "hello"+name+", this messge send failed";
    }
    
}
