package io;

import pojos.AircraftType;
import pojos.Airline;
import pojos.Airport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/*
    Created by: Jonas Seidl
    Date: 18.11.2021
    Time: 13:23
*/
public class Import {
    private final static Path typePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "aircrafttypes.csv");
    private final static Path airlinePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "airlines.csv");
    private final static Path airportPath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "airports.csv");

    public static List<AircraftType> getAircraftTypes(){
        List<AircraftType> aircraftTypes = new ArrayList<>();

        try {
            aircraftTypes.addAll(Files.lines(typePath).skip(1).map(AircraftType::new).collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aircraftTypes;
    }

    public static List<Airline> getAirlines(){
        List<Airline> airlines = new ArrayList<>();

        try {
            airlines.addAll(Files.lines(airlinePath).skip(1).map(Airline::new).collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return airlines;
    }

    public static List<Airport> getAirports(){
        List<Airport> airports = new ArrayList<>();

        try {
            airports.addAll(Files.lines(airportPath).skip(1).map(Airport::new).collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return airports;
    }
}
