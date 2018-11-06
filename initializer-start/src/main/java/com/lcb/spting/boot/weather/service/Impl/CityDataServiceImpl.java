package com.lcb.spting.boot.weather.service.Impl;

import com.lcb.spting.boot.weather.service.CityDataService;
import com.lcb.spting.boot.weather.util.XmlBuilder;
import com.lcb.spting.boot.weather.vo.City;
import com.lcb.spting.boot.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
@Service
public class CityDataServiceImpl implements CityDataService {


    @Override
    public List<City> listCity() throws Exception {
        //读取xml文件
        Resource resource=new ClassPathResource("static/city.xml");
        BufferedReader bf=new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
        StringBuffer buffer=new StringBuffer();
        String line = "";
        while((line=bf.readLine()) != null){
            buffer.append(line);
        }
        bf.close();
        //XML转换为JAVA对象
        CityList cityList= (CityList)XmlBuilder.xmlStrToObject(CityList.class,buffer.toString());
        return cityList.getCityList();
    }
}
