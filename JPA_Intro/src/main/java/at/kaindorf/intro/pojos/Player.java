package at.kaindorf.intro.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 08.10.2021
    Time: 10:51
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    @Id
    private int playerId;

    @ManyToMany(mappedBy = "players")
    private List<Team> teams = new ArrayList<>();
}
