package at.kaindorf.customerdb.util;

import at.kaindorf.customerdb.pojos.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXB;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
    Created by: Jonas Seidl
    Date: 21.09.2021
    Time: 09:18
*/
public class ImportHandler {

    private static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);

    public static List<Customer> readCustomersJSON(){
        ObjectMapper om = new ObjectMapper();
        ClassLoader classLoader = ImportHandler.class.getClassLoader();
        File file = new File(classLoader.getResource("customers.json").getFile());


        List<Customer> customers = null;
        try {
            customers = Arrays.asList(om.readValue(file, Customer[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static List<Customer> readCustomersXML(){
        ClassLoader classLoader = ImportHandler.class.getClassLoader();
        File file = new File(classLoader.getResource("customers.xml").getFile());
        List<CustomerXML> customers = JAXB.unmarshal(file, CustomerList.class).getCustomers();
        System.out.println(customers);
        return null;
    }

    private static Customer convertCustomer(CustomerXML xml){
        String firstname = xml.getFirstname();
        String lastname = xml.getLastname();
        char gender = xml.getGender().charAt(0);
        boolean active = Boolean.parseBoolean(xml.getActive());
        String email = xml.getEmail();
        LocalDate since = LocalDate.parse(xml.getSince(), DTF);

        Customer customer = new Customer(firstname, lastname, gender, active, email, since);

        String streetName = xml.getStreetname();
        int streetNumber = Integer.parseInt(xml.getStreetnumber());
        String city = xml.getCity();
        String postal_code = xml.getPostal_code();

        Address address = new Address(streetName, streetNumber, postal_code, city);

        address.addCustomer(customer);

        String countryName = xml.getCountry();
        String countryCode = xml.getCountry_code();

        Country country = new Country(countryName, countryCode);

        country.addAddress(address);

        return customer;
    }
}
