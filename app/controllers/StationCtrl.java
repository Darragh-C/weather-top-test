package controllers;

import play.Logger;
import play.mvc.Controller;
import java.util.List;

import models.Reading;
import models.Station;
import utils.StationAnalytics;

import static play.mvc.Controller.redirect;


public class StationCtrl extends Controller {
    public static void index(Long id)
    {
        
        Station station = Station.findById(id);
        Logger.info ("Station id = " + id);

        Reading latestReading = null;
        if (station.readings.size() > 0) 
        {
            latestReading = station.readings.get(station.readings.size()-1);
        }
        
        double fahrenheit = StationAnalytics.getCelsiusToFahrenheit(latestReading);
        double windChill = StationAnalytics.getWindChillCalc(latestReading);
        int beaufort = StationAnalytics.getBeaufortSelector(latestReading);
        String windDirection = StationAnalytics.getWindDirection(latestReading);
        
        render("station.html", station, latestReading, fahrenheit, windChill, beaufort, windDirection);
       
        
    }
    public static void addReading(Long id, int code, double temperature, double windSpeed, long pressure, int windDirection)
    {
        Reading reading = new Reading(code, temperature, windSpeed, pressure, windDirection);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        redirect ("/stations/" + id);
    }
}
