package models;

import play.db.jpa.Model;
import java.util.HashMap;

import javax.persistence.Entity;

@Entity
public class Reading extends Model
{
    public int code;
    public double temperature;
    public double windSpeed;
    public int windDirection;
    public long pressure;
    private HashMap<Integer, String> weatherCodeMap;



    public Reading(int code, double temperature, double windSpeed, long pressure, int windDirection)
    {
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.windDirection = windDirection;
    }

    public String weatherCondition()
    {
        weatherCodeMap = new HashMap<Integer, String>();
        fillWeatherCodeMap();
        int index = this.code;
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

    

    private String windDirection()
    {
        int windDir = this.windDirection;
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


}
