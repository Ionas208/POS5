package at.kaindorf.customerdb.pojos;

import lombok.Data;

/*
    Created by: Jonas Seidl
    Date: 23.09.2021
    Time: 10:19
*/
@Data
public class CustomerXML {
    private String country;
    private String country_code;
    private String city;
    private String postal_code;
    private String streetname;
    private String streetnumber;
    private String firstname;
    private String lastname;
    private String gender;
    private String active;
    private String email;
    private String since;
}
