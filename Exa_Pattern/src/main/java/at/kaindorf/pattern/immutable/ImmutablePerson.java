package at.kaindorf.pattern.immutable;

/*
    Created by: Jonas Seidl
    Date: 04.03.2022
    Time: 10:10
*/
public final class ImmutablePerson {
    private final String name;
    private final int age;
    private final Address address;

    public ImmutablePerson(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = new Address(address.getStreetname(), address.getZipCode());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return new Address(address.getStreetname(), address.getZipCode());
    }
}