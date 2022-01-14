package at.kaindorf.intro.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.*;

/*
    Created by: Jonas Seidl
    Date: 21.09.2021
    Time: 08:52
*/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Country {
    @Id
    @GeneratedValue
    @Column(name = "country_id")
    private Long countryId;

    @NonNull
    @Column(name = "name", length = 50)
    private String name;

    @NonNull
    @Column(name = "code", length = 10)
    private String code;

    @NonNull
    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private List<Address> addresses = new ArrayList<>();

}
