package com.lcb.msaweathercollectioneureka.weather.job;


import com.lcb.msaweathercollectioneureka.weather.service.CityClient;
import com.lcb.msaweathercollectioneureka.weather.service.WeatherDataConllectionService;
import com.lcb.msaweathercollectioneureka.weather.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

//定时任务 实时实现天气数据同步
public class WeatherDataSyncJob extends QuartzJobBean {
    @Autowired
    private WeatherDataConllectionService weatherDataCollectionService;
    @Autowired
    private CityClient cityClient;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        //获取城市ID列表
        List<City> citylist = null;
        try {
            citylist = cityClient.listCity();
        } catch (Exception e) {

        }
        //便利城市ID获取天气
        for (City city : citylist) {
            String cityId = city.getCityId();
            weatherDataCollectionService.sysncDataByCityId(cityId);
        }

    }
}
