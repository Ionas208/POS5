import at.kaindorf.intro.pojos.Address;
import at.kaindorf.intro.pojos.SchoolClass;
import at.kaindorf.intro.pojos.Student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

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
        SchoolClass sc = new SchoolClass("5DHIF");
        sc.addStudent(s);

        em.persist(sc);
        em.getTransaction().commit();

        TypedQuery<Student> typedQuery = em.createQuery("SELECT s FROM Student s", Student.class);
        List<Student> students = typedQuery.getResultList();
        System.out.println(students);

        TypedQuery<Address> namedQuery = em.createNamedQuery("Address.GetAll", Address.class);
        namedQuery.setParameter("city","Paldau");
        List<Address> addresses = namedQuery.getResultList();
        System.out.println(addresses);

        em.close();
        emf.close();
    }
}
