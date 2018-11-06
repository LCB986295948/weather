package com.lcb.msaweatherdataeureka.weather.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcb.msaweatherdataeureka.weather.service.WeatherDataService;
import com.lcb.msaweatherdataeureka.weather.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private final static Logger logger= LoggerFactory.getLogger(WeatherResponse.class);
    private static  final String url="http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public WeatherResponse getDateaBtCityId(String cityId) {
        String uri=url+"citykey="+cityId;
        return  this.doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri=url+"city="+cityName;
        return  this.doGetWeather(uri);
    }
    /**
     * 实现重用
     * @param uri
     * @return
     */
    private  WeatherResponse doGetWeather(String uri){
        WeatherResponse resp = null;
        String key=uri;
        String strBody = null;
        ObjectMapper mapper=new ObjectMapper();
       ValueOperations<String,String> ops=stringRedisTemplate.opsForValue();
        if(stringRedisTemplate.hasKey(key)){
            logger.info("Redis do has data");
            strBody =  ops.get(key);
        }else{
            logger.info("Redis don't has data");
          throw new RuntimeException("Don't has data!");
        }
        try {
            resp=mapper.readValue(strBody,WeatherResponse.class);
        } catch (IOException e) {
            logger.error("ERROR!",e);
        }
        return resp;
    }
}
