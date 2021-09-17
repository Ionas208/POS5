import at.kaindorf.intro.pojos.Address;
import at.kaindorf.intro.pojos.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.Month;

/*
    Created by: Jonas Seidl
    Date: 14.09.2021
    Time: 09:29
*/
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_JPA_Intro");
        EntityManager em = emf.createEntityManager();

        Student s = new Student("5DHIF", Long.valueOf(22), "Jonas", "Seidl", LocalDate.of(2002, Month.AUGUST,20));
        Address a = new Address("Paldau","Perlsdorf","122");
        s.setAddress(a);

        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
