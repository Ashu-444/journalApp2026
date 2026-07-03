package com.amakeit.journalApp.service;

import com.amakeit.journalApp.api.response.WeatherResponse;
import com.amakeit.journalApp.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//@Component
@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String API_KEY;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    @Autowired
    private RedisService redisService;

    public WeatherResponse getWeather(String city) {
        WeatherResponse weatherResponse = redisService.get("Weather_of_" + city, WeatherResponse.class);
        if(weatherResponse != null){
            return weatherResponse;
        } else {
            String finalAPI = appCache.APP_CACHE.get("weather_api").replace("<city>", city).replace("<apiKey>", API_KEY);
//            System.out.println(finalAPI);
            ResponseEntity<WeatherResponse> body = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
            if(body.getBody() != null){
                redisService.set("Weather_of_" + city , body , 300L);
            }
            return body.getBody();
        }
    }
}