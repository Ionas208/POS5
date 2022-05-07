package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    Created by: Jonas Seidl
    Date: 07.04.2022
    Time: 16:32
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    private String name;
    private int position;
    private int played;
    private int won;
    private int drawn;
    private int loss;
    private int gs;
    private int ga;
    private int gd;
    private int pts;
}
