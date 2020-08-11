package com.study.boot.service.impl;

import com.study.boot.bean.City;
import com.study.boot.mapper.CityMapper;
import com.study.boot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<City> selectAllCity() {
        return cityMapper.selectAllCity();
    }

    @Override
    public List<City> selectCity(City city) {
        return cityMapper.selectCity(city);
    }
}
