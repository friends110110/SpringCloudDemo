package com.example.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {

    @Autowired
    private DiscoveryClient client;

    @GetMapping(value = "/hello")
    public String index(){
        client.getServices().forEach(e -> {
            System.out.println(e);
            ServiceInstance instance = client.getInstances(e).get(0);
            System.out.println("host:" + instance.getHost() + " server_id:" + instance.getServiceId());

            });
        return "hello world!";
    }
}
