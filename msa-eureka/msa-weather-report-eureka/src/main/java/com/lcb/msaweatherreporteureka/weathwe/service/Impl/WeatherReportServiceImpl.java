package com.lcb.msaweatherreporteureka.weathwe.service.Impl;


import com.lcb.msaweatherreporteureka.weathwe.service.WeatherDataClient;
import com.lcb.msaweatherreporteureka.weathwe.service.WeatherReportService;
import com.lcb.msaweatherreporteureka.weathwe.service.dataClient;
import com.lcb.msaweatherreporteureka.weathwe.vo.Forecast;
import com.lcb.msaweatherreporteureka.weathwe.vo.Weather;
import com.lcb.msaweatherreporteureka.weathwe.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WeatherReportServiceImpl implements WeatherReportService {
   // @Autowired
  //  private WeatherDataClient weatherDataClient;
   @Autowired
    private dataClient dataclient;
    @Override
    public Weather getDataCityId(String cityId) {
       // WeatherResponse resp= weatherDataClient.getDataByCityId(cityId);
        WeatherResponse resp= dataclient.getDataByCityId(cityId);
        Weather data=resp.getData();
        return data;
    }
}
