package at.kaindorf.customerdb.pojos;

import at.kaindorf.customerdb.json.CustomerDeserializer;
import at.kaindorf.customerdb.util.BidirectionalUtil;
import at.kaindorf.customerdb.xml.CustomerAdapter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.inject.Named;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/*
    Created by: Jonas Seidl
    Date: 21.09.2021
    Time: 08:52
*/
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@JsonDeserialize(using = CustomerDeserializer.class)
@NamedQueries({
        @NamedQuery(name="Customer.FindYears", query = "SELECT DISTINCT EXTRACT(YEAR from c.since) FROM Customer c"),
        @NamedQuery(name="Customer.CountAll", query = "SELECT COUNT(c) FROM Customer c"),
        @NamedQuery(name="Customer.FindFromCountry", query = "SELECT c FROM Customer c WHERE c.address.country.code = :country_code")
})
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

    public void setAddress(Address address) {
        address = BidirectionalUtil.getUniqueAddress(address);
        this.address = address;
    }


}
