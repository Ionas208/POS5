package pojos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
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
public class Publisher {
    @XmlElement(name="publisherId")
    private Integer id;
    private String name;
    private String url;
    @XmlElementWrapper(name="booklist")
    @XmlElement(name="book")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Book> books;
}
