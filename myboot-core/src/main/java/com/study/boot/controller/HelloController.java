package com.study.boot.controller;

import com.study.boot.bean.City;
import com.study.boot.kafka.KafkaProduct;
import com.study.boot.service.CityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    Logger logger = LogManager.getLogger(HelloController.class);

    @Autowired
    private CityService cityService;

    @Autowired
    private KafkaProduct kafkaProduct;

    @RequestMapping(value = "hello")
    public String hello(String name){
        List<City> cities = cityService.selectAllCity();
        City city = cities.get(0);
        int i=0;
        while (i<=10){
            kafkaProduct.sendAsync("hello:"+i,"test");
            i++;
        }
        logger.info("success");
        return "success";
    }


    @RequestMapping(value = "city")
    @ResponseBody
    //requestBody
    //不支持get提交，或者转为json字符串提交curl -H "Content-Type: application/json"  --data '{"id":"1"}' http://localhost/myboot/core/city
    public City getCity(@RequestBody(required = false) City city, City city2){
        if (city!=null) {
           return cityService.selectCity(city).get(0);
        }
        if (city2!=null){
            return cityService.selectCity(city2).get(0);
        }
        return cityService.selectAllCity().get(0);
    }

    @RequestMapping(value = "allCity")
    @ResponseBody
    public List<City> selectAllCity(){
        List<City> cities = cityService.selectAllCity();
        return cities;
    }
}
