package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller
{
  public static void index() {
    Logger.info("Rendering Dashboard");

    List<Station> stations = Station.findAll();
    render ("dashboard.html", member, stations);
  }

  public static void addStation (String name)
  {
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(name);
    member.station.add(station);
    member.save();
    Logger.info ("Adding a new station called " + name);
    redirect ("/dashboard");
  }

}