package at.kaindorf.m2m.pojos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 12.11.2021
    Time: 08:16
*/
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_M2M");
        EntityManager em = emf.createEntityManager();

        Actor a = new Actor("Franz");
        Actor a2 = new Actor("Hans");
        Movie m = new Movie("LMAO");
        Movie m2 = new Movie("LMAO2");

        a.addMovie(m);
        a.addMovie(m2);
        a2.addMovie(m);
        m.addActor(a);
        m.addActor(a2);

        em.getTransaction().begin();
        em.persist(a);
        em.persist(a2);
        Query q = em.createNamedQuery("test");
        System.out.println(q.getResultList());

        q = em.createNativeQuery("SELECT * FROM movie");
        List<Object[]>  movies = q.getResultList();
        for (Object[] mo: movies) {
            System.out.println(mo[1]);
        }
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
