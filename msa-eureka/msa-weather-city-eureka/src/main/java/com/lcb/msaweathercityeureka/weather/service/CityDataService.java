package com.lcb.msaweathercityeureka.weather.service;



import com.lcb.msaweathercityeureka.weather.vo.City;

import java.util.List;

public interface CityDataService {
    /**
     * 获取city列表
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;
}
