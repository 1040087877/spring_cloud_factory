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
    public String hello2(String name) {
        return "hello"+name+", this messge send failed";
    }
    
}
