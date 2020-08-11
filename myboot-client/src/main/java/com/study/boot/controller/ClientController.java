package com.study.boot.controller;

import com.study.boot.bean.City;
import com.study.boot.feign.HelloFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HelloFeign helloFeign;

    @RequestMapping("hello1")
    public String testClient1(){
        String result = restTemplate.getForObject("http://myboot-core/myboot/core/hello", String.class);
        return result;
    }

    @RequestMapping("hello2")
    public String testClient2(){
        String result = helloFeign.hello();
        return result;
    }

    @RequestMapping("city")
    @ResponseBody
    public City getCity(Integer id){
        City city = new City();city.setId(id);
        return helloFeign.getCity(city);
    }

    @RequestMapping("allCity")
    @ResponseBody
    public List<City> getAllCity(){
        List<City> cities = helloFeign.getAllCity();
        return cities;
    }
}
