package io;

import pojos.*;

import java.time.LocalTime;
import java.util.*;

/*
    Created by: Jonas Seidl
    Date: 18.11.2021
    Time: 13:44
*/
public class RandomData {
    public static List<Aircraft> createRandomAircraft(List<Airline> airlines, List<Airport> airports, List<AircraftType> aircraftTypes){
        Random r = new Random(0);
        List<Aircraft> aircrafts = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Airline randomAirline = airlines.get(r.nextInt(airlines.size()));
            AircraftType randomType = aircraftTypes.get(r.nextInt(aircraftTypes.size()));
            Aircraft randomAircraft = new Aircraft(randomAirline, randomType);
            aircrafts.add(randomAircraft);
            //System.out.println(randomAircraft);
        }
        return aircrafts;
    }

    public static List<Flight> createRandomFlights(List<Airline> airlines, List<Airport> airports, List<AircraftType> aircraftTypes, List<Aircraft> aircrafts){
        Random r = new Random(0);
        List<Flight> flights = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            Aircraft randomAircraft = aircrafts.get(r.nextInt(aircrafts.size()));
            Airline randomAirline = randomAircraft.getAirline();
            Airport randomDepartureAirport = airports.get(r.nextInt(airports.size()));
            Airport randomArrivalAirport = airports.get(r.nextInt(airports.size()));
            LocalTime randomDepartureTime = LocalTime.of(r.nextInt(24), r.nextInt(60));
            LocalTime randomArrivalTime = randomDepartureTime.plusHours(r.nextInt(16)).plusMinutes(r.nextInt(60));

            Flight randomFlight = new Flight(randomAircraft, randomAirline, randomDepartureTime, randomDepartureAirport, randomArrivalTime, randomArrivalAirport);
            flights.add(randomFlight);
        }
        return flights;
    }
}
