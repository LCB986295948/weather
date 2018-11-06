package com.lcb.msaweathercityeureka.weather.action;


import com.lcb.msaweathercityeureka.weather.service.CityDataService;
import com.lcb.msaweathercityeureka.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/citys")
public class CityController {
    @Autowired
    private CityDataService cityDataService;
    @GetMapping
    public List<City> listCity() throws Exception{
        return  cityDataService.listCity();
    }
}
