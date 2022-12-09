package org.zerock.ex01.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.ex01.entity.WeatherAD;
import org.zerock.ex01.repository.WeatherFoodRepository;

@Slf4j
@Service
public class WeatherFoodService {
    @Autowired
    WeatherFoodRepository weatherFoodRepository;

    public WeatherAD getWeatherFood(String weather){
        WeatherAD entity=weatherFoodRepository.getWeatherADByWeatherType(weather);
        return entity;
    }


}
