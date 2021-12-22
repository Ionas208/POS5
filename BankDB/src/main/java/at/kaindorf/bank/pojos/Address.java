package at.kaindorf.bank.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
    Created by: Jonas Seidl
    Date: 22.12.2021
    Time: 14:47
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "streetname", length = 100)
    private String streetname;

    @Column(name = "street_number", length = 10)
    private String streetNumber;

    @Column(name = "zip_code", length = 10)
    private String zipCode;

    @Column(name = "city", length = 100)
    private String city;
}
