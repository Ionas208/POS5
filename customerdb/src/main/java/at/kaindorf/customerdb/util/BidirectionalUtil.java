package at.kaindorf.customerdb.util;

import at.kaindorf.customerdb.pojos.Address;
import at.kaindorf.customerdb.pojos.Country;
import at.kaindorf.customerdb.pojos.Customer;

import java.util.HashSet;
import java.util.Set;

/*
    Created by: Jonas Seidl
    Date: 28.09.2021
    Time: 08:38
*/
public class BidirectionalUtil {
    private static Set<Country> countries = new HashSet<>();
    private static Set<Address> addresses = new HashSet<>();

    public static Country getUniqueCountry(Country country){
        for (Country c: countries) {
            if(c.equals(country)){
                return c;
            }
        }
        addUniqueCountry(country);
        return country;
    }

    public static void addUniqueCountry(Country country){
        if(!countries.contains(country)){
            countries.add(country);
        }
    }

    public static Address getUniqueAddress(Address address){
        for (Address a: addresses) {
            if(a.equals(address)){
                return a;
            }
        }
        addUniqueAddress(address);
        return address;
    }

    public static void addUniqueAddress(Address address){
        if(!addresses.contains(address)){
            addresses.add(address);
        }
    }
}
