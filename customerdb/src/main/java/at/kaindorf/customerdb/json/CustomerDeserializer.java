package at.kaindorf.customerdb.json;

import at.kaindorf.customerdb.pojos.Address;
import at.kaindorf.customerdb.pojos.Country;
import at.kaindorf.customerdb.pojos.Customer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/*
    Created by: Jonas Seidl
    Date: 21.09.2021
    Time: 09:25
*/
public class CustomerDeserializer extends StdDeserializer<Customer> {

    public CustomerDeserializer() {
        super(Customer.class);
    }

    private static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);


    @Override
    public Customer deserialize(JsonParser p, DeserializationContext dc) throws IOException, JsonProcessingException {

        JsonNode node = dc.readValue(p, JsonNode.class);

        String firstname = node.get("firstname").toString().replace("\"","");
        String lastname = node.get("lastname").toString().replace("\"","");
        char gender = node.get("gender").toString().charAt(1);
        boolean active = Boolean.parseBoolean(node.get("active").toString().replace("\"",""));
        String email = node.get("email").toString().replace("\"","");
        String sinceText = node.get("since").toString().replace("\"","");
        LocalDate since = LocalDate.parse(sinceText, DTF);
        Customer customer = new Customer(firstname, lastname, gender, active, email, since);

        String streetname = node.get("streetname").toString().replace("\"","");
        int streetnumber = Integer.parseInt(node.get("streetnumber").toString().replace("\"",""));
        String postal_code = node.get("postal_code").toString().replace("\"","");
        String city = node.get("city").toString().replace("\"","");
        Address address = new Address(streetname, streetnumber, postal_code, city);

        String c = node.get("country").toString().replace("\"","");
        String country_code = node.get("country_code").toString().replace("\"","");
        Country country = new Country(c, country_code);

        country.addAddress(address);
        address.setCountry(country);
        address.addCustomer(customer);
        customer.setAddress(address);

        return customer;
    }
}
