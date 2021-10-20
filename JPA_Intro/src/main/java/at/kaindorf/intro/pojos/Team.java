package at.kaindorf.intro.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
public class Team {
    @Id
    private int teamId;

    @ManyToMany
    @JoinTable(name="player_team",
            joinColumns = {@JoinColumn(name="team_xid")},
            inverseJoinColumns = {@JoinColumn(name="player_id")}
    )
    private List<Player> players = new ArrayList<>();
}
