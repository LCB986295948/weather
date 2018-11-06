package com.lcb.msaweatherreporteureka.weathwe.service;



import com.lcb.msaweatherreporteureka.weathwe.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("msa-weather-data-eureka")
public interface WeatherDataClient {
    @GetMapping("/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
