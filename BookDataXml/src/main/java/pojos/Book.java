package pojos;

import jakarta.xml.bind.annotation.*;
import lombok.*;

import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 25.03.2022
    Time: 11:15
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
    @XmlElement(name="bookId")
    private Integer id;
    private String title;
    private String url;
    private Double price;
    private String isbn;

    @XmlElementWrapper(name="authorlist")
    @XmlElement(name="author")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Author> authors;

    @XmlTransient
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Publisher publisher;

}
