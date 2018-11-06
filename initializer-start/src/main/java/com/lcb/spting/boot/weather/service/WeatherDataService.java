package com.lcb.spting.boot.weather.service;

import com.lcb.spting.boot.weather.vo.WeatherResponse;


public interface WeatherDataService {

    /**
     * 根据城市ID查询天气数据
     */
    WeatherResponse getDateaBtCityId(String cityId);
    /**
     * 根据城市名称查询天气数据
     */

    WeatherResponse getDataByCityName(String cityName);

    /**
     * 根据城市ID同步天气
     * @param cityId
     */
    void syncDataByCityId(String cityId);
}

