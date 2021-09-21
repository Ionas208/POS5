package at.kaindorf.customerdb.json;

import at.kaindorf.customerdb.pojos.Address;
import at.kaindorf.customerdb.pojos.Country;
import at.kaindorf.customerdb.pojos.Customer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

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
        String c = node.get("country").toString();
        String country_code = node.get("country_code").toString();
        Country country = new Country(c, country_code);

        String streetname = node.get("streetname").toString();
        int streetnumber = Integer.parseInt(node.get("streetnumber").toString().replace("\"",""));
        String postal_code = node.get("postal_code").toString();
        String city = node.get("city").toString();
        Address address = new Address(streetname, streetnumber, postal_code, city, country);


        String firstname = node.get("firstname").toString();
        String lastname = node.get("lastname").toString();
        char gender = node.get("gender").toString().charAt(0);
        boolean active = Boolean.parseBoolean(node.get("active").toString());
        String email = node.get("email").toString();
        String sinceText = node.get("since").toString().replace("\"","");
        LocalDate since = LocalDate.parse(sinceText, DTF);
        return new Customer(firstname, lastname, gender, active, email, since, address);
    }
}
