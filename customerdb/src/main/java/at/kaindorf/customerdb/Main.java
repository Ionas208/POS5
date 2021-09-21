package at.kaindorf.customerdb;

import at.kaindorf.customerdb.pojos.Address;
import at.kaindorf.customerdb.pojos.Country;
import at.kaindorf.customerdb.pojos.Customer;
import at.kaindorf.customerdb.util.ImportHandler;
import org.eclipse.persistence.internal.oxm.schema.model.Import;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.Month;

/*
    Created by: Jonas Seidl
    Date: 21.09.2021
    Time: 08:54
*/
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_CUSTOMERDB");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.getTransaction().commit();

        em.close();
        emf.close();

        ImportHandler.readCustomersJSON();
    }
}
