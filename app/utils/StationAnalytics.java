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

    public static int getBeaufortSelector(Reading reading) {
        double wind = reading.windSpeed;
        if (wind <= 1)
        {
            return 0;
        }
        if (wind > 1 && wind <= 5)
        {
            return 1;
        }
        if (wind >= 6 && wind <= 11)
        {
            return 2;
        }
        if (wind >= 12 && wind <= 19)
        {
            return 3;
        }
        if (wind >= 20 && wind <= 28)
        {
            return 4;
        }
        if (wind >= 29 && wind <= 38)
        {
            return 5;
        }
        if (wind >= 39 && wind <= 49)
        {
            return 6;
        }
        if (wind >= 50 && wind <= 61)
        {
            return 7;
        }
        if (wind >= 62 && wind <= 74)
        {
            return 8;
        }
        if (wind >= 75 && wind <= 88)
        {
            return 9;
        }
        if (wind >= 89 && wind <= 102)
        {
            return 10;
        }
        if (wind >= 103 && wind <= 117)
        {
            return 11;
        }
        else return 999;
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
