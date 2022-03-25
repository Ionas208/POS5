package pojos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 25.03.2022
    Time: 11:16
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Author {
    @XmlElement(name="authorId")
    private Integer id;
    private String firstname;
    private String lastname;
    private String url;

    @XmlTransient
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Book> books = new ArrayList<>();
}
