package com.lcb.msaweathercityeureka.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Scanner;

@SpringBootApplication
@EnableDiscoveryClient
public class MsaWeatherCityEurekaApplication {

    public static void main(String[] args) {

       SpringApplication.run(MsaWeatherCityEurekaApplication.class, args);
    }
}
