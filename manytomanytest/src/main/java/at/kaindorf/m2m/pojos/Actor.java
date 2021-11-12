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
//@NamedQuery(name = "test", query = "SELECT a FROM Movie m join m.actors a")
@NamedQuery(name = "test", query = "SELECT m.actors FROM Movie m WHERE m.movieId=2")
public class Actor {
    @Id
    @GeneratedValue
    @Column(name = "actor_id")
    private int actorId;

    @NonNull
    @Column(name = "name")
    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "movie_actor",
            joinColumns = {
                    @JoinColumn(name = "actor_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name="movie_id")
            }
    )
    private List<Movie> movies = new ArrayList<>();
    //private Set<Movie> movies = new HashSet<>();

    public void addMovie(Movie movie){
        movies.add(movie);
    }
}
