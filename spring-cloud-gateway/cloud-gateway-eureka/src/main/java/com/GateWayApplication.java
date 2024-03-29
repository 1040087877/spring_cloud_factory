package com;
import com.filter.RateLimitByIpGatewayFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@SpringBootApplication
public class GateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class,args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", r -> r.path("/about")
                        .uri("http://ityouknow.com"))
                .route(r -> r.path("/throttle/customer/**")
                        .filters(f -> f.stripPrefix(2)
                                .filter(new RateLimitByIpGatewayFilter(10,1,Duration.ofSeconds(1))))
                        .uri("lb://spring-cloud-producer")
                        .order(0)
                        .id("throttle_customer_service")
                )
                .build();
    }
}
