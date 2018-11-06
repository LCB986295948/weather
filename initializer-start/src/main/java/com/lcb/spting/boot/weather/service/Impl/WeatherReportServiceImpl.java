package com.lcb.spting.boot.weather.service.Impl;

import com.lcb.spting.boot.weather.service.WeatherDataService;
import com.lcb.spting.boot.weather.service.WeatherReportService;
import com.lcb.spting.boot.weather.vo.Weather;
import com.lcb.spting.boot.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    @Autowired
    private WeatherDataService weatherDataService;
    @Override
    public Weather getDataCityId(String cityId) {
       WeatherResponse  resp= weatherDataService.getDateaBtCityId(cityId);
        return resp.getData();
    }
}
