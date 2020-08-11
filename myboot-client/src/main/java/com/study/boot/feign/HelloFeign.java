package com.study.boot.feign;

import com.study.boot.bean.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "myboot-core")
public interface HelloFeign {

    @RequestMapping("/myboot/core/hello")
    String hello();

    @RequestMapping(value = "/myboot/core/city",method = RequestMethod.GET,consumes = "application/json")
    City getCity(@RequestBody City city);

    @RequestMapping("/myboot/core/allCity")
    List<City> getAllCity();
}
