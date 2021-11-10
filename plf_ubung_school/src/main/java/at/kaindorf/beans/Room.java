package at.kaindorf.beans;

import at.kaindorf.bl.Floor;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

/*
    Created by: Jonas Seidl
    Date: 10.11.2021
    Time: 17:06
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="roomId")
    private Integer roomId;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name="floor")
    @Enumerated
    private Floor floor;

    @OneToOne(mappedBy = "room", cascade = CascadeType.ALL)
    private Classname classname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return Objects.equals(roomId, room.roomId) && name.equals(room.name) && floor == room.floor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, name, floor);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", name='" + name + '\'' +
                ", floor=" + floor +
                '}';
    }
}
