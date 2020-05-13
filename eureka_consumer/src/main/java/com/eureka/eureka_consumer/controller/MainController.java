package com.eureka.eureka_consumer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    EurekaClient client;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/hello")
    public String getHello(){

        return "Hello";
    }

    @GetMapping("/client")
    public String client(){
        List<String> services = discoveryClient.getServices();
        for (String str : services)
            System.out.println(str);

        return "Hello";
    }

    @GetMapping("/client2")
    public Object client2(){

        return discoveryClient.getInstances("provider");
    }


    @GetMapping("/client3")
    public Object client3(){

        List<ServiceInstance> instances = discoveryClient.getInstances("provider");

        for (ServiceInstance instance: instances) {
            System.out.println(ToStringBuilder.reflectionToString(instance));
        }


        return "instance";
    }


    @GetMapping("/client4")
    public Object client4(){

        List<InstanceInfo> instances = client.getInstancesByVipAddress("provider",false);

        for (InstanceInfo instance: instances) {
            System.out.println(ToStringBuilder.reflectionToString(instance));
        }

        if (instances.size()>0) {
            InstanceInfo instance = instances.get(0);
            if (instance.getStatus()== InstanceInfo.InstanceStatus.UP){
                String url = "http://"+instance.getHostName()+":"+instance.getPort()+"/hello";
                System.out.println(url);
                RestTemplate restTemplate = new RestTemplate();
                String result = restTemplate.getForObject(url,String.class);
                System.out.println(result);
            }
        }
        return "client";
    }

    @GetMapping("/client5")
    public Object client5(){
        ServiceInstance instance = loadBalancerClient.choose("provider");

        String url = "http://"+instance.getHost()+":"+instance.getPort()+"/hello";

        System.out.println(url);

        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(url,String.class);

        System.out.println(result);

        return "loadBalancerClient";
    }
}
