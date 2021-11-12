package at.kaindorf.m2m.pojos;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    Created by: Jonas Seidl
    Date: 12.11.2021
    Time: 08:11
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Movie {
    @Id
    @GeneratedValue
    @Column(name = "movie_id")
    private int movieId;

    @NonNull
    @Column(name = "title")
    private String title;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "movies")
    //private Set<Actor> actors = new HashSet<>();
    private List<Actor> actors = new ArrayList<>();

    public void addActor(Actor actor){
        actors.add(actor);
    }
}
