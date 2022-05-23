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
    
    public double maxTemperature;
    public double minTemperature;
    public long maxPressure;
    public long minPressure;
    public double maxWindSpeed;
    public double minWindSpeed;
    
   public Reading(int code, double temperature, double windSpeed, long pressure, int windDirection)
    {
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.windDirection = windDirection;
    }
    
    public Reading(int code, double temperature, double windSpeed, long pressure, int windDirection, double maxTemperature, double minTemperature, long maxPressure, long minPressure, double maxWindSpeed, double minWindSpeed)
    {
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.windDirection = windDirection;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.maxPressure = maxPressure;
        this.minPressure = minPressure;
        this.maxWindSpeed = maxWindSpeed;
        this.minWindSpeed = minWindSpeed;
    }

    
}
