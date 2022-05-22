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
}
