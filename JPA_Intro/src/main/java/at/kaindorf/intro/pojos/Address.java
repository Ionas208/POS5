package at.kaindorf.intro.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

/*
    Created by: Jonas Seidl
    Date: 16.09.2021
    Time: 10:02
*/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name="Address.GetAll", query = "SELECT a FROM Address a WHERE a.city = :city"),
        @NamedQuery(name="Address.GetByClassname", query = "SELECT a FROM Address a"),
})
public class Address implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="address_id", nullable = false)
    private Long addressId;

    @NonNull
    @Column(nullable = false)
    private String city;

    @NonNull
    @Column(nullable = false)
    private String street;

    @NonNull
    @Column(nullable = false)
    private String number;

    public Address(@NonNull String city, @NonNull String street, @NonNull String number) {
        this.city = city;
        this.street = street;
        this.number = number;
    }
}
