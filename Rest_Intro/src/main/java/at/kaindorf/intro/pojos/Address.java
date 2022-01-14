package at.kaindorf.intro.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
    Created by: Jonas Seidl
    Date: 21.09.2021
    Time: 08:52
*/
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private Long addressId;

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

    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private List<Customer> customers = new ArrayList<>();
}

