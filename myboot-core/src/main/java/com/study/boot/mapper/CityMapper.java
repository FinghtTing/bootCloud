package com.study.boot.mapper;

import com.study.boot.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CityMapper {

    List<City> selectAllCity();

    List<City> selectCity(City city);
}
