package pojos;

import org.junit.jupiter.api.Test;

import javax.persistence.*;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;


/*

@NamedQueries({
        @NamedQuery(name = "aircraftsFromAirlineOnAirport", query = "SELECT COUNT(ac) FROM Airport ap join ap.aircrafts ac join ac.airline al " +
                "WHERE ap.name = :airport AND al.name = :airline"),
        @NamedQuery(name = "flightsFromAirport", query = "SELECT COUNT(f) FROM Flight f WHERE f.departure_airport.name = :airport"),
        @NamedQuery(name = "aircraftTypesFromAirline", query = "SELECT COUNT(ac.type.name) FROM Aircraft ac WHERE ac.airline.name = :airline GROUP BY ac.type.name "),
        @NamedQuery(name = "departureFlightsFromAirlineInTimeSpan", query = "SELECT f FROM Flight f " +
                "WHERE f.departure > :start_date AND f.departure < :end_date AND f.airline.name = :airline"),
        @NamedQuery(name = "flightsFromAirline", query = "SELECT COUNT(f) FROM Flight f GROUP BY f.airline.name"),
        @NamedQuery(name = "arrivalFlightsFromAirlineInTimeSpan", query = "SELECT f FROM Flight f " +
                "WHERE f.arrival > :start_date AND f.arrival < :end_date AND f.airline.name = :airline"),
        @NamedQuery(name = "mostFlightsToCountry", query = "SELECT f.arrival_airport.country, COUNT(f) FROM Flight f GROUP BY f.arrival_airport.country"),
        @NamedQuery(name = "mostFlightsFromCountry", query = "SELECT f.arrival_airport.country, COUNT(f) FROM Flight f GROUP BY f.departure_airport.country"),
        @NamedQuery(name = "mostFlightsToCity", query = "SELECT MAX(COUNT(f)) FROM Flight f GROUP BY f.arrival_airport.city"),
})
 */
class FlightTest {

    @Test
    void aircraftsFromAirlineOnAirport() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_AIRLINE");
        EntityManager em = emf.createEntityManager();

        Airport airport = em.find(Airport.class, 225);
        Airline airline = em.find(Airline.class, new AirlinePK(203, "Peran"));

        TypedQuery<Long> q = em.createNamedQuery("aircraftsFromAirlineOnAirport", Long.class);
        q.setParameter("airport", airport);
        q.setParameter("airline", airline);

        long result = q.getSingleResult();

        em.close();
        emf.close();

        assertEquals(0, result);
    }

    @Test
    void flightsFromAirport(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_AIRLINE");
        EntityManager em = emf.createEntityManager();

        Airport airport = em.find(Airport.class, 225);

        TypedQuery<Long> q = em.createNamedQuery("flightsFromAirport", Long.class);
        q.setParameter("airport", airport);

        long result = q.getSingleResult();

        em.close();
        emf.close();

        assertEquals(905, result);
    }

    @Test
    void departureFlightsFromAirlineInTimeSpan(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_AIRLINE");
        EntityManager em = emf.createEntityManager();

        Airline airline = em.find(Airline.class, new AirlinePK(203, "Peran"));

        TypedQuery<Long> q = em.createNamedQuery("departureFlightsFromAirlineInTimeSpan", Long.class);
        q.setParameter("start_date", LocalTime.of(0,0));
        q.setParameter("end_date", LocalTime.of(6,0));
        q.setParameter("airline", airline);

        long result = q.getSingleResult();

        em.close();
        emf.close();

        assertEquals(2378, result);
    }

    @Test
    void flightsFromAirline(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_AIRLINE");
        EntityManager em = emf.createEntityManager();

        Airline airline = em.find(Airline.class, new AirlinePK(203, "Peran"));

        TypedQuery<Long> q = em.createNamedQuery("flightsFromAirline", Long.class);
        q.setParameter("airline", airline);

        long result = q.getSingleResult();

        em.close();
        emf.close();

        assertEquals(9863, result);
    }

    @Test
    void arrivalFlightsFromAirlineInTimeSpan(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_AIRLINE");
        EntityManager em = emf.createEntityManager();

        Airline airline = em.find(Airline.class, new AirlinePK(203, "Peran"));

        TypedQuery<Long> q = em.createNamedQuery("arrivalFlightsFromAirlineInTimeSpan", Long.class);
        q.setParameter("start_date", LocalTime.of(12,0));
        q.setParameter("end_date", LocalTime.of(23,59));
        q.setParameter("airline", airline);

        long result = q.getSingleResult();

        em.close();
        emf.close();

        assertEquals(4949, result);
    }

    @Test
    void aircraftsFromAirline(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_AIRLINE");
        EntityManager em = emf.createEntityManager();

        Airline airline = em.find(Airline.class, new AirlinePK(203, "Peran"));

        TypedQuery<Long> q = em.createNamedQuery("aircraftsFromAirline", Long.class);
        q.setParameter("airline", airline);

        long result = q.getSingleResult();

        em.close();
        emf.close();

        assertEquals(10, result);
    }

    @Test
    void flightsToAirport(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_AIRLINE");
        EntityManager em = emf.createEntityManager();

        Airport airport = em.find(Airport.class, 225);

        TypedQuery<Long> q = em.createNamedQuery("flightsToAirport", Long.class);
        q.setParameter("airport", airport);

        long result = q.getSingleResult();

        em.close();
        emf.close();

        assertEquals(968, result);
    }

    @Test
    void flightsToCountry(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_AIRLINE");
        EntityManager em = emf.createEntityManager();

        Airport airport = em.find(Airport.class, 225);

        TypedQuery<Long> q = em.createNamedQuery("flightsToCountry", Long.class);
        q.setParameter("country", airport.getCountry());

        long result = q.getSingleResult();

        em.close();
        emf.close();

        assertEquals(33507, result);
    }

    @Test
    void flightsFromAircraft(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_AIRLINE");
        EntityManager em = emf.createEntityManager();

        Aircraft aircraft = em.find(Aircraft.class, 390);

        TypedQuery<Long> q = em.createNamedQuery("flightsFromAircraft", Long.class);
        q.setParameter("aircraft", aircraft);

        long result = q.getSingleResult();

        em.close();
        emf.close();

        assertEquals(984, result);
    }

}