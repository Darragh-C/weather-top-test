package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import java.util.List;
import java.util.ArrayList;

@Entity
public class Station extends Model
{
    public String name;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();
    public double latitude;
    public double longitude;


    public Station(String name, double longitude, double latitude)
    {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public List<Reading> getReadings() {
        return readings;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
