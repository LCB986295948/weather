package com.lcb.msaweatherreporteureka.weathwe.action;


import com.lcb.msaweatherreporteureka.weathwe.service.CityClient;
import com.lcb.msaweatherreporteureka.weathwe.service.WeatherReportService;
import com.lcb.msaweatherreporteureka.weathwe.service.dataClient;
import com.lcb.msaweatherreporteureka.weathwe.vo.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@RestController
@RequestMapping("/report")
public class WeatherReportController {
    @Autowired
    private WeatherReportService weatherReportService;
  //  @Autowired
   // private CityClient cityClient;
   @Autowired
    private dataClient dataclient;
    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId (@PathVariable("cityId") String  cityId, Model model) throws  Exception{
      // List<City> citylist =cityClient.listCity();
        List<City> citylist =dataclient.cityList();
        model.addAttribute("title","小路的天气预报");
        model.addAttribute("cityId",cityId);
        model.addAttribute("cityList",citylist);
        model.addAttribute("report",weatherReportService.getDataCityId(cityId));
        return new ModelAndView("weather/report","reportModel",model);
    }
}
