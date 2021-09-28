package at.kaindorf.customerdb.pojos;

import lombok.*;

import javax.inject.Named;
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
@NamedQueries({
        @NamedQuery(name="Country.FindByName", query="SELECT c FROM Country c WHERE c.name = :name"),
        @NamedQuery(name="Country.FindAll", query="SELECT c FROM Country c"),
        @NamedQuery(name="Country.CountAll", query="SELECT COUNT(c) FROM Country c")
})
public class Country {

    public static Set<Country> countries = new HashSet<>();

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

    public void addAddress(Address address){
        if(!addresses.contains(address)){
            addresses.add(address);
        }
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return countryId == country.countryId && name.equals(country.name) && code.equals(country.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, name, code);
    }
}
