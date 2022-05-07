package pojos;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 07.04.2022
    Time: 16:32
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "Meisterschaft")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tournament {
    @XmlAttribute(name = "Name")
    private String name;
    @XmlElement(name = "Spiel")
    @XmlElementWrapper(name = "Spiele")
    private List<Game> games;
}
