package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 获取所有服务
     * http://localhost:8504/services
     */
    @RequestMapping("/services")
    public Object services() {
        return discoveryClient.getInstances("service-producer");
    }

    /**
     * 从所有服务中选择一个服务（轮询） http://localhost:8504/discover
     */
    @RequestMapping("/discover")
    public Object discover(){
        return loadBalancerClient.choose("service-producer").getUri().toString();
    }
}
