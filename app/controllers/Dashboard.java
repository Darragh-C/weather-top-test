package controllers;

import java.util.ArrayList;
import java.util.List;

import utils.StationAnalytics;

import models.Member;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller
{
  public static void index() {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = member.stations;
    
    render("dashboard.html", member, stations);
    
  }

  public static void addStation (String name, double longitude, double latitude)
  {
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(name, longitude, latitude);
    member.stations.add(station);
    member.save();
    Logger.info ("Adding a new station called " + name);
    redirect ("/dashboard");
  }

  public static void deleteStation(Long id)
  {
    Logger.info ("Deleting station: " + id);
    Member member = Accounts.getLoggedInMember();
    Station station = Station.findById(id);
    member.stations.remove(station);
    member.save();
    station.delete();
    redirect ("/dashboard");
  }

}