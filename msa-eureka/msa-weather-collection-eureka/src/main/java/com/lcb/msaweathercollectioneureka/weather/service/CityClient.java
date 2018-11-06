package com.lcb.msaweathercollectioneureka.weather.service;

import com.lcb.msaweathercollectioneureka.weather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("msa-weather-city-eureka")
public interface CityClient {
    @GetMapping("/citys")
    List<City> listCity() throws Exception;
}
