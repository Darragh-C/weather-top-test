package utils;

import models.Reading;

import java.util.List;

public class StationAnalytics 
{
    public static Reading getLatestReading(List<Reading> readings) 
    {
        Reading latestReading = null;
        
        if (readings.size() > 0) 
        {
            latestReading = readings.get(-1);
        }
        
        return latestReading;
    }
}