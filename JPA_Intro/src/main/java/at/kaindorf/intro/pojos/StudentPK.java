package at.kaindorf.intro.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
    Created by: Jonas Seidl
    Date: 16.09.2021
    Time: 09:40
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentPK implements Serializable {
    private long catNo;
    private String classname;
}
