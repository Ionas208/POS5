package pojos;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 25.03.2022
    Time: 11:16
*/
@XmlRootElement(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class PublisherList {

    @XmlElement(name = "publisher")
    @XmlElementWrapper(name = "publisherlist")
    private List<Publisher> publishers;
}
