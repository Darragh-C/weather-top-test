package utils;

import models.Reading;

import java.util.List;
import java.util.HashMap;

public class StationAnalytics 
{
    private HashMap<Integer, String> weatherCodeMap;
    public static Reading getLatestReading(List<Reading> readings)
    {
        Reading latestReading = null;
        
        if (readings.size() > 0) 
        {
            latestReading = readings.get(readings.size() -1);
        }
        
        return latestReading;
    }

    public String weatherCondition(Reading reading)
    {
        weatherCodeMap = new HashMap<Integer, String>();
        fillWeatherCodeMap();
        int index = reading.code;
        return weatherCodeMap.get(index);
    }

    private void fillWeatherCodeMap(){
        weatherCodeMap.put(100,"Clear");
        weatherCodeMap.put(200,"Partial clouds");
        weatherCodeMap.put(300,"Cloudy");
        weatherCodeMap.put(400,"Light showers");
        weatherCodeMap.put(500,"Heavy showers");
        weatherCodeMap.put(600,"Rain");
        weatherCodeMap.put(700,"Snow");
        weatherCodeMap.put(800,"Thunder");
    }

 
}
