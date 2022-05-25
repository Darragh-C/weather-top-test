package utils;

import models.Reading;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class StationAnalytics 
{
    private static HashMap<Integer, String> weatherCodeMap;
    private static HashMap<Integer, String> weatherIconMap;

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

    public static String getWindDirection(Reading reading)
    {
        int windDir = reading.windDirection;
        if (windDir >= 348.75 || windDir < 11.25)
        {
            return "North";
        }
        if (windDir >= 11.25 && windDir < 33.75)
        {
            return "North North East";
        }
        if (windDir >= 33.75 && windDir < 56.25)
        {
            return "North East";
        }
        if (windDir >= 56.25 && windDir < 78.75)
        {
            return "East North East";
        }
        if (windDir >= 78.75 && windDir < 101.25)
        {
            return "East";
        }
        if (windDir >= 101.25 && windDir < 123.75)
        {
            return "East South East";
        }
        if (windDir >= 123.75 && windDir < 146.25)
        {
            return "South East";
        }
        if (windDir >= 146.25 && windDir < 168.75)
        {
            return "South South East";
        }
        if (windDir >= 168.75 && windDir < 191.25)
        {
            return "South";
        }
        if (windDir >= 191.25 && windDir < 213.75)
        {
            return "South South West";
        }
        if (windDir >= 213.75 && windDir < 236.25)
        {
            return "South West";
        }
        if (windDir >= 236.25 && windDir < 258.75)
        {
            return "West South West";
        }
        if (windDir >= 258.75 && windDir < 281.25)
        {
            return "West";
        }
        if (windDir >= 281.25 && windDir < 303.75)
        {
            return "West North West";
        }
        if (windDir >= 303.75 && windDir < 326.25)
        {
            return "North West";
        }
        if (windDir >= 326.25 && windDir < 348.75)
        {
            return "North North West";
        }
        else return "Not within range";
    }

    public static String getWeatherCondition(Reading reading)
    {
        weatherCodeMap = new HashMap<Integer, String>();
        fillWeatherCodeMap();
        int index = reading.code;
        return weatherCodeMap.get(index);
    }

    private static void fillWeatherCodeMap(){
        weatherCodeMap.put(100,"Clear");
        weatherCodeMap.put(200,"Partial clouds");
        weatherCodeMap.put(300,"Cloudy");
        weatherCodeMap.put(400,"Light showers");
        weatherCodeMap.put(500,"Heavy showers");
        weatherCodeMap.put(600,"Rain");
        weatherCodeMap.put(700,"Snow");
        weatherCodeMap.put(800,"Thunder");
    }

    public static String getWeatherIcon(Reading reading)
    {
        weatherIconMap = new HashMap<Integer, String>();
        fillWeatherIconMap();
        int index = reading.code;
        return weatherIconMap.get(index);
    }

    private static void fillWeatherIconMap(){
        weatherIconMap.put(100,"sun icon");
        weatherIconMap.put(200,"cloud sun icon");
        weatherIconMap.put(300,"cloud icon");
        weatherIconMap.put(400,"cloud sun rain icon");
        weatherIconMap.put(500,"cloud showers heavy icon");
        weatherIconMap.put(600,"cloud rain icon");
        weatherIconMap.put(700,"snowflake outline icon");
        weatherIconMap.put(800,"bolt icon");
    }
    
    public static boolean checkForTrend(List<Reading> readings)
    {
        Reading lastReading = readings.get(readings.size()-1);
        double lastMeasurement = lastReading.temperature;
        Reading secondLastReading = readings.get(readings.size()-2);
        double secondLastMeasurement = secondLastReading.temperature;
        Reading thirdLastReading = readings.get(readings.size()-3);
        double thirdLastMeasurement = thirdLastReading.temperature;
        
        if (lastMeasurement > secondLastMeasurement && secondLastMeasurement > thirdLastMeasurement)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    

 
}
