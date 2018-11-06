package com.lcb.msaweatherreporteureka.weathwe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MsaWeatherReportEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaWeatherReportEurekaApplication.class, args);
    }
}
