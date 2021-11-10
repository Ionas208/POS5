package at.kaindorf.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 10.11.2021
    Time: 17:19
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "Schule")
@XmlAccessorType(XmlAccessType.FIELD)
public class DummyList {
    @XmlElement(name = "Lehrer")
    private List<Dummy> dummies = null;
}
