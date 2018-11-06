package com.lcb.msaweatherreporteureka.weathwe.service;

import com.lcb.msaweatherreporteureka.weathwe.vo.City;
import com.lcb.msaweatherreporteureka.weathwe.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("hellowordclientzuul")
public interface dataClient {
    /**
     * 根据城市ID获取城市列表
     * @return
     * @throws Exception
     */
    @GetMapping("/city/citys")
    List<City> cityList() throws  Exception;
    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
