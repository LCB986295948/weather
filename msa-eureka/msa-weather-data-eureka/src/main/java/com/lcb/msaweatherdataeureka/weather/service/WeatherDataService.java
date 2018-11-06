package com.lcb.msaweatherdataeureka.weather.service;


import com.lcb.msaweatherdataeureka.weather.vo.WeatherResponse;

public interface WeatherDataService {

    /**
     * 根据城市ID查询天气数据
     */
    WeatherResponse getDateaBtCityId(String cityId);
    /**
     * 根据城市名称查询天气数据
     */

    WeatherResponse getDataByCityName(String cityName);


}

