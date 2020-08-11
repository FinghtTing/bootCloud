package com.study.boot.service;

import com.study.boot.bean.City;

import java.util.List;

public interface CityService {

    List<City> selectAllCity();

    List<City> selectCity(City city);
}
