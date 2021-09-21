package at.kaindorf.customerdb.pojos;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 21.09.2021
    Time: 08:52
*/
@Entity(name="country")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Country {
    @Id
    @GeneratedValue
    @Column(name = "country_id")
    private int countryId;

    @NonNull
    @Column(name = "name", length = 50)
    private String name;

    @NonNull
    @Column(name = "code", length = 10)
    private String code;

    @NonNull
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Address> addresses = new ArrayList<>();

    public void addAddress(Address a){
        if(!addresses.contains(a)){
            addresses.add(a);
            a.setCountry(this);
        }
    }
}
