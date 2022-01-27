package at.kaindorf.bank.pojos;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 22.12.2021
    Time: 14:47
*/
@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Account {
    @Id
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "account_number")
    private Long accountNumber;

    @Column(name = "balance")
    private Double balance;

    @ManyToMany(mappedBy = "accounts")
    private List<Customer> customer;
}
