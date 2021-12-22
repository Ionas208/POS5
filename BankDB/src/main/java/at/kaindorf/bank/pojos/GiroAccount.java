package at.kaindorf.bank.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*
    Created by: Jonas Seidl
    Date: 22.12.2021
    Time: 14:47
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("Giro")
public class GiroAccount extends Account {
    @Column(name="overdraft")
    private Double overdraft;

    @Column(name="debit_interest")
    private Float debitInterest;

    @Column(name="credit_interest")
    private float creditInterest;
}
