package at.kaindorf.intro.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;

/*
    Created by: Jonas Seidl
    Date: 21.09.2021
    Time: 08:52
*/
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    private Long customerID;

    @NonNull
    @Column(name = "firstname", length = 100)
    @XmlElement
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

    @ManyToOne
    @JoinColumn(name = "address")
    private Address address;


}
