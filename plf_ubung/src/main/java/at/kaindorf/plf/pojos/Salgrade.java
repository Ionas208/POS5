package at.kaindorf.plf.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
    Created by: Jonas Seidl
    Date: 27.01.2022
    Time: 11:42
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salgrade {
    @Id
    private Integer grade;

    private Integer losal;

    private Integer hisal;
}
