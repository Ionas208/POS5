import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    }
}
