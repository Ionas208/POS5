package at.kaindorf.customerdb.util;

import at.kaindorf.customerdb.pojos.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 21.09.2021
    Time: 09:18
*/
public class ImportHandler {
    public static List<Customer> readCustomersJSON(){
        List<Customer> customers = new ArrayList<>();
        String jsonString = "{\n" +
                "        \"country\": \"United States\",\n" +
                "        \"country_code\": \"US\",\n" +
                "        \"city\": \"San Antonio\",\n" +
                "        \"postal_code\": \"78205\",\n" +
                "        \"streetname\": \"Anthes\",\n" +
                "        \"streetnumber\": \"41131\",\n" +
                "        \"firstname\": \"Francois\",\n" +
                "        \"lastname\": \"Craythorn\",\n" +
                "        \"gender\": \"M\",\n" +
                "        \"active\": true,\n" +
                "        \"email\": \"fcraythorn0@google.it\",\n" +
                "        \"since\": \"13-Jan-2018\"\n" +
                "    }";
        ObjectMapper om = new ObjectMapper();

        try {
            Customer c = om.readValue(jsonString, Customer.class);
            System.out.println(c);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
