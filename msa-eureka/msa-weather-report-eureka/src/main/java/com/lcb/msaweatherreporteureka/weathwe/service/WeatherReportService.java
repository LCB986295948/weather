package com.lcb.msaweatherreporteureka.weathwe.service;


import com.lcb.msaweatherreporteureka.weathwe.vo.Weather;

public interface WeatherReportService {
    /**
     * 根据城市ID获取天气
     * @param cityId
     * @return
     */
    Weather getDataCityId(String cityId);
}
