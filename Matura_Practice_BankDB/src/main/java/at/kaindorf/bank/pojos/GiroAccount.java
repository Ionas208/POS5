package at.kaindorf.bank.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*
    Created by: Jonas Seidl
    Date: 06.05.2022
    Time: 15:56
*/
@Entity
@DiscriminatorValue("GIRO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GiroAccount extends Account {
    @Column(name="overdraft")
    private Double overdraft;

    @Column(name="debit_interest")
    private Float debitInterest;

    @Column(name="credit_interest")
    private Float creditInterest;
}
