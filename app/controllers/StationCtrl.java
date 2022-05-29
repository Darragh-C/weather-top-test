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
        double fahrenheit = 0.0;
        double windChill = 0.0;
        int beaufort = 0;
        String windDirection = null;
        String weatherCondition = null;
        String weatherIcon = null;
        String temperatureTrend = null;
        String pressureTrend = null;
        String windSpeedTrend = null;

        if (latestReading != null) {
            fahrenheit = StationAnalytics.getCelsiusToFahrenheit(latestReading);
            windChill = StationAnalytics.getWindChillCalc(latestReading);
            beaufort = StationAnalytics.getBeaufortSelector(latestReading);
            windDirection = StationAnalytics.getWindDirection(latestReading);
            weatherCondition = StationAnalytics.getWeatherCondition(latestReading);
            weatherIcon = StationAnalytics.getWeatherIcon(latestReading);
            
            if (station.readings.size() >= 3) {
                temperatureTrend = StationAnalytics.getTemperatureTrend(StationAnalytics.getLastThreeReadings(station.readings));
                pressureTrend = StationAnalytics.getPressureTrend(StationAnalytics.getLastThreeReadings(station.readings));
                windSpeedTrend = StationAnalytics.getWindSpeedTrend(StationAnalytics.getLastThreeReadings(station.readings));
            }
        }

        render("station.html", station, latestReading, fahrenheit, windChill, beaufort, windDirection, weatherCondition, weatherIcon, temperatureTrend, pressureTrend, windSpeedTrend);


    }
    public static void addReading(Long id, int code, double temperature, double windSpeed, long pressure, int windDirection, double maxTemperature, double minTemperature, long maxPressure, long minPressure, double maxWindSpeed, double minWindSpeed)
    {
        Reading reading = new Reading(code, temperature, windSpeed, pressure, windDirection, maxTemperature, minTemperature, maxPressure, minPressure, maxWindSpeed, minWindSpeed);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        redirect ("/stations/" + id);
    }

    public static void deleteReading(Long id, Long readingid)
    {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);
        Logger.info("Removing " + readingid + " from station " + id);
        station.readings.remove(reading);
        station.save();
        reading.delete();
        index(id);
    }
}