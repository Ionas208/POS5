package at.kaindorf.customerdb.pojos;

import at.kaindorf.customerdb.util.BidirectionalUtil;
import lombok.*;

import javax.persistence.*;
import java.util.*;

/*
    Created by: Jonas Seidl
    Date: 21.09.2021
    Time: 08:52
*/
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@NamedQueries({
        @NamedQuery(name="Address.CountAll", query = "SELECT COUNT(a) FROM Address a")
})
public class Address {
    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private int addressId;

    @NonNull
    @Column(name = "street_name", length = 100)
    private String streetName;

    @NonNull
    @Column(name = "street_number", nullable = false)
    private int streetNumber;

    @NonNull
    @Column(name = "postal_code", length = 50)
    private String postalCode;

    @NonNull
    @Column(name = "city", length = 100)
    private String city;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="country")
    private Country country;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer){
        if(!customers.contains(customer)){
            customers.add(customer);
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", streetName='" + streetName + '\'' +
                ", streetNumber=" + streetNumber +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country=" + country +
                '}';
    }

    public void setCountry(Country country) {
        country = BidirectionalUtil.getUniqueCountry(country);
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return addressId == address.addressId && streetNumber == address.streetNumber && streetName.equals(address.streetName) && postalCode.equals(address.postalCode) && city.equals(address.city) && country.equals(address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, streetName, streetNumber, postalCode, city, country);
    }
}

