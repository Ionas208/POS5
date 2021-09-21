package at.kaindorf.customerdb.pojos;

import at.kaindorf.customerdb.json.CustomerDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/*
    Created by: Jonas Seidl
    Date: 21.09.2021
    Time: 08:52
*/
@Entity(name="customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@JsonDeserialize(using = CustomerDeserializer.class)
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    private int customerID;

    @NonNull
    @Column(name = "firstname", length = 100)
    private String firstname;

    @NonNull
    @Column(name = "lastname", length = 100)
    private String lastname;

    @NonNull
    @Column(name = "gender", length = 1, nullable = false)
    private char gender;

    @NonNull
    @Column(name = "active", nullable = false)
    private boolean active;

    @NonNull
    @Column(name = "email", length = 255)
    private String email;

    @NonNull
    @Column(name = "since")
    private LocalDate since;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "address")
    private Address address;
}
