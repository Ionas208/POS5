package at.kaindorf.customerdb;

import at.kaindorf.customerdb.pojos.Address;
import at.kaindorf.customerdb.pojos.Country;
import at.kaindorf.customerdb.pojos.Customer;
import at.kaindorf.customerdb.util.ImportHandler;
import org.eclipse.persistence.internal.oxm.schema.model.Import;

import javax.enterprise.inject.Typed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

/*
    Created by: Jonas Seidl
    Date: 21.09.2021
    Time: 08:54
*/
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_CUSTOMERDB");
        EntityManager em = emf.createEntityManager();


        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        do{
            System.out.println("-------------");
            System.out.println("-----JPA-----");
            System.out.println("-------------");
            List<Customer> customers = null;
            do{
                System.out.println("Read Data From XML [X] or JSON [J]?");
                String input = scanner.nextLine();
                switch(input.toUpperCase()){
                    case "X":
                        customers = ImportHandler.readCustomersXML();
                        System.out.println("Successfully imported from XML.");
                        break;
                    case "J":
                        customers = ImportHandler.readCustomersJSON();
                        System.out.println("Successfully imported from JSON.");
                        break;
                    default:
                        System.out.println("Invalid Input. Please try again.\n");
                }
            }while(customers == null);

            em.getTransaction().begin();
            for (Customer c: customers) {
                em.persist(c);
            }
            em.getTransaction().commit();

            boolean doQuery = true;
            do{
                System.out.println("[1] Find Country By Name");
                System.out.println("[2] Find All Countries");
                System.out.println("[3] Count All Countries");
                System.out.println("[4] Count All Addresses");
                System.out.println("[5] Find All Unique Years");
                System.out.println("[6] Count All Customers");
                System.out.println("[7] Find All Customers From Country");
                String input = scanner.nextLine();
                try{
                    switch(Integer.parseInt(input)){
                        case 1:
                            TypedQuery<Country> countriesByName = em.createNamedQuery("Country.FindByName", Country.class);
                            System.out.println("Enter Country Name:");
                            String country = scanner.nextLine();
                            countriesByName.setParameter("name", country);
                            System.out.println(countriesByName.getResultList());
                            break;
                        case 2:
                            TypedQuery<Country> allCountries = em.createNamedQuery("Country.FindAll", Country.class);
                            System.out.println(allCountries.getResultList());
                            break;
                        case 3:
                            TypedQuery<Integer> countCountries = em.createNamedQuery("Country.CountAll", Integer.class);
                            System.out.println(countCountries.getSingleResult());
                            break;
                        case 4:
                            TypedQuery<Integer> countAddresses = em.createNamedQuery("Address.CountAll", Integer.class);
                            System.out.println(countAddresses.getSingleResult());
                            break;
                        case 5:
                            TypedQuery<Integer> uniqueYears = em.createNamedQuery("Customer.FindYears", Integer.class);
                            System.out.println(uniqueYears.getResultList());
                            break;
                        case 6:
                            TypedQuery<Integer> countCustomers = em.createNamedQuery("Customer.CountAll", Integer.class);
                            System.out.println(countCustomers.getSingleResult());
                            break;
                        case 7:
                            TypedQuery<Country> customersByCountry = em.createNamedQuery("Customer.FindFromCountry", Country.class);
                            System.out.println("Enter Country Code:");
                            String country_code = scanner.nextLine();
                            customersByCountry.setParameter("country_code", country_code);
                            System.out.println(customersByCountry.getResultList());
                            break;
                        default:
                            System.out.println("Invalid Input.");
                    }
                }catch(NumberFormatException ex){
                    System.out.println("Invalid Input.");
                }
                System.out.println("Continue to Query? [Y\\N]");
                String doQueryInput = scanner.nextLine();
                switch(doQueryInput.toUpperCase()){
                    case "Y":
                        doQuery = true;
                        break;
                    default:
                        doQuery = false;
                }
            }while(doQuery);
            System.out.println("Exit? [Y\\N]");
            String doExit = scanner.nextLine();
            switch(doExit.toUpperCase()){
                case "Y":
                    exit = true;
                    break;
            }
        }while(!exit);

        em.close();
        emf.close();
    }
}
