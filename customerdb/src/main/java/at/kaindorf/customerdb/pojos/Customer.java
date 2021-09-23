package at.kaindorf.customerdb.pojos;

import at.kaindorf.customerdb.json.CustomerDeserializer;
import at.kaindorf.customerdb.xml.CustomerAdapter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
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
@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlJavaTypeAdapter(CustomerAdapter.class)
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    private int customerID;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    private Address address;

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender=" + gender +
                ", active=" + active +
                ", email='" + email + '\'' +
                ", since=" + since +
                '}';
    }
}
