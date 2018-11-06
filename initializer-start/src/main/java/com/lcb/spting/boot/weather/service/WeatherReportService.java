package com.lcb.spting.boot.weather.service;

import com.lcb.spting.boot.weather.vo.Weather;

public interface WeatherReportService {
    /**
     * 根据城市ID获取天气
     * @param cityId
     * @return
     */
    Weather getDataCityId(String cityId);
}
