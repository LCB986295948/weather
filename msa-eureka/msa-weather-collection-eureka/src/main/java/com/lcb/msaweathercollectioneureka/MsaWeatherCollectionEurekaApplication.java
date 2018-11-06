package com.lcb.msaweathercollectioneureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsaWeatherCollectionEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaWeatherCollectionEurekaApplication.class, args);
    }
}
