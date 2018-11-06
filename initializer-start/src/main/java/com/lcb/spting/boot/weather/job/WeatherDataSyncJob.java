package com.lcb.spting.boot.weather.job;


import com.lcb.spting.boot.weather.service.CityDataService;
import com.lcb.spting.boot.weather.service.WeatherDataService;
import com.lcb.spting.boot.weather.vo.City;
import com.lcb.spting.boot.weather.vo.WeatherResponse;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

//定时任务 实时实现天气数据同步
public class WeatherDataSyncJob extends QuartzJobBean {
    private final  static Logger logger=LoggerFactory.getLogger(WeatherResponse.class);
    @Autowired
    private CityDataService cityDataService;
    @Autowired
    private WeatherDataService weatherDataService;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("Weather Data Sync Start");
        //获取城市ID列表
        List<City> citylist=null;
        try {
            citylist = cityDataService.listCity();
        }catch (Exception e){
            logger.error("Exception!",e);
        }
        //便利城市ID获取天气
        for(City city : citylist){
            String cityId=city.getCityId();
            logger.info("Weather Data Sync Job,cityId:"+cityId);
            weatherDataService.syncDataByCityId(cityId);
        }
        logger.info("Weather Data Sync Job,End!");
    }
}
