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
@DiscriminatorValue("SPAR")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavingsAccount extends Account {
    @Column(name = "interest")
    private Double interest;
}
