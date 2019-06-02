package day01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class 启动器 {
    public static void main(String[] args) {
        SpringApplication.run(启动器.class,args);
    }
}
