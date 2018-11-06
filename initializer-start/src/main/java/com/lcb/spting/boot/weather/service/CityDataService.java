package com.lcb.spting.boot.weather.service;

import com.lcb.spting.boot.weather.vo.City;

import java.util.List;

public interface CityDataService {
    /**
     * 获取city列表
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;
}
