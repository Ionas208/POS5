import io.Import;
import io.RandomData;
import pojos.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Random;

/*
    Created by: Jonas Seidl
    Date: 22.10.2021
    Time: 11:55
*/
public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_AIRLINE");
        EntityManager em = emf.createEntityManager();

        Random r = new Random(0);

        List<Airline> airlines = Import.getAirlines();
        List<Airport> airports = Import.getAirports();
        List<AircraftType> aircraftTypes = Import.getAircraftTypes();

        airlines.removeIf(airline -> r.nextInt(500)!=0);
        airports.removeIf(airline -> r.nextInt(500)!=0);
        aircraftTypes.removeIf(airline -> r.nextInt(500)!=0);

        System.out.println("Airlines: "+airlines.size());
        System.out.println("Airports: "+airports.size());
        System.out.println("AircraftTypes: "+aircraftTypes.size());

        List<Aircraft> aircrafts = RandomData.createRandomAircraft(airlines, airports, aircraftTypes);
        List<Flight> flights = RandomData.createRandomFlights(airlines, airports, aircraftTypes, aircrafts);

        System.out.println("Aircrafts: "+aircrafts.size());
        System.out.println("Flights: "+flights.size());

        for (Aircraft a: aircrafts) {
            Airline airline = a.getAirline();
            airline.addAircraft(a);
        }

        for (Flight f: flights) {
            Airline airline = f.getAirline();
            airline.addFlight(f);
            Airport departureAirport = f.getDeparture_airport();
            departureAirport.addDepartureFlight(f);
            Airport arrivalAirport = f.getArrival_airport();
            arrivalAirport.addArrivalFlight(f);
        }

        em.getTransaction().begin();
        for (AircraftType t: aircraftTypes) {
            em.persist(t);
        }
        for (Airline a: airlines) {
            em.persist(a);
        }
        for (Airport a: airports) {
            em.persist(a);
        }
        for (Aircraft a: aircrafts) {
            em.persist(a);
        }
        for (Flight f: flights) {
            em.persist(f);
        }
        /**
         * ----------------------------------------------------------------------------------
         * IF YOU WANT TO TEST, REMOVE "javax.persistence.schema-generation.database.action"
         * FROM persistence.xml AND RUN FlightTest
         * ----------------------------------------------------------------------------------
         */
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
