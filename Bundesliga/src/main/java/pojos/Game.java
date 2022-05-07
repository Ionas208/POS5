package pojos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/*
    Created by: Jonas Seidl
    Date: 07.04.2022
    Time: 16:32
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Game {
    @XmlAttribute(name="Runde")
    private int round;
    @XmlElement(name="Mannschaft1")
    private String team1;
    @XmlElement(name="Mannschaft2")
    private String team2;
    @XmlElement(name="Tore1")
    private int goal1;
    @XmlElement(name="Tore2")
    private int goal2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return (
                (game.team1.equals(this.team1) && game.team2.equals(this.team2))
                        ||
                (game.team2.equals(this.team1) && game.team1.equals(this.team2))
        ) && (
                (game.goal1 == this.goal1 && game.goal2 == this.goal2)
                        ||
                (game.goal1 == this.goal2 && game.goal2 == this.goal1)
        ) && (game.round == this.round);
    }

    @Override
    public int hashCode() {
        return Objects.hash(round, team1, team2, goal1, goal2);
    }
}
