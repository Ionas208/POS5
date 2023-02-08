package at.kaindorf.bank.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
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
public class Customer {
    @Id
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "customer_number")
    private Long customerNumber;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany
    @JoinTable(
            name = "customer_account",
            joinColumns = {
                    @JoinColumn(name = "customer_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "account_id")
            }
    )
    private List<Account> accounts;

}
