package at.kaindorf.bank.pojos;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 06.05.2022
    Time: 15:56
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @Column(name="address_id")
    private Long addressId;

    @Column(name="streetname")
    private String streetname;

    @Column(name="street_number")
    private String streetNumber;

    @Column(name="zip_code")
    private String zipCode;

    @Column(name="city")
    private String city;

    @OneToMany(mappedBy="address")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Customer> customers;
}
