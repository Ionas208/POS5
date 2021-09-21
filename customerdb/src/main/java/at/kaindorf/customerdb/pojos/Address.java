package at.kaindorf.customerdb.pojos;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 21.09.2021
    Time: 08:52
*/
@Entity(name="address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
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

    @NonNull
    @ManyToOne
    @JoinColumn(name="country")
    private Country country;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Customer> customers = new ArrayList<>();

    public void addAddress(Customer c){
        if(!customers.contains(c)){
            customers.add(c);
           c.setAddress(this);
        }
    }
}

