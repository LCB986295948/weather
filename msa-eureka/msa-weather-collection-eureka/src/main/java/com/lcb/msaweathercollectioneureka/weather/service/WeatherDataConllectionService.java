package com.lcb.msaweathercollectioneureka.weather.service;

/**
 * 天气数据采集接口
 */
public interface WeatherDataConllectionService {
    /**
     * 根据城市Id同步天气
     *
     * @param cityId
     */
    void sysncDataByCityId(String cityId);
}
