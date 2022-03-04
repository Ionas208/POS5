package at.kaindorf.pattern.immutable;

/*
    Created by: Jonas Seidl
    Date: 04.03.2022
    Time: 10:18
*/
public class Address {
    private String streetname;
    private int zipCode;

    public Address(String streetname, int zipCode) {
        this.streetname = streetname;
        this.zipCode = zipCode;
    }

    public String getStreetname() {
        return streetname;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String setStreetname(String streetname) {
        return this.streetname = streetname;
    }

    public int setZipCode(int zipCode) {
        return this.zipCode = zipCode;
    }
}
