package utils;

import models.Reading;

import java.util.List;
import java.util.HashMap;

public class StationAnalytics 
{
    private HashMap<Integer, String> weatherCodeMap;

    public static double getCelsiusToFahrenheit(Reading reading)
    {
        double celsius = reading.temperature;
        return celsius * (9/5) + 32;
    }

    public static double getWindChillCalc(Reading reading)
    {
        double t = reading.temperature;
        double v = reading.windSpeed;

        return 13.12 + (0.6215 * t) - (11.37 * (Math.pow(v, 0.16))) + ((0.3965 * t)*(Math.pow(v, 0.16)));
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
