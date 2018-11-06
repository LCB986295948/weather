package com.lcb.spting.boot.weather.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcb.spting.boot.weather.service.WeatherDataService;
import com.lcb.spting.boot.weather.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private final static Logger logger= LoggerFactory.getLogger(WeatherResponse.class);
    private static  final String url="http://wthrcdn.etouch.cn/weather_mini?";
    private static  final long Time_Out = 1800L;
    @Autowired
    private RestTemplate restTemplate;
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

    @Override
    public void syncDataByCityId(String cityId) {
        String uri=url+"citykey="+cityId;
         this.saveWeatherData(uri);
    }
    private  void saveWeatherData(String uri){
        String key=uri;
        String strBody = null;
        ValueOperations<String,String> ops=stringRedisTemplate.opsForValue();
            ResponseEntity<String> respString =restTemplate.getForEntity(uri,String.class);
            if(respString.getStatusCodeValue() == 200){
                strBody = respString.getBody();
            }
            ops.set(key,strBody,Time_Out,TimeUnit.SECONDS);

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
            ResponseEntity<String> respString =restTemplate.getForEntity(uri,String.class);
            if(respString.getStatusCodeValue() == 200){
                strBody = respString.getBody();
            }
            ops.set(key,strBody,Time_Out,TimeUnit.SECONDS);
        }
        try {
            resp=mapper.readValue(strBody,WeatherResponse.class);
        } catch (IOException e) {
            logger.error("ERROR!",e);
        }
        return resp;
    }
}
