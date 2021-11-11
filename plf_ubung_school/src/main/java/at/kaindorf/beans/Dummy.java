package at.kaindorf.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/*
    Created by: Jonas Seidl
    Date: 10.11.2021
    Time: 17:18
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Dummy {
    @XmlElement(name = "Kürzel")
    private String initials;
    @XmlElement(name="Titel")
    private String title;
    @XmlElement(name = "Familienname")
    private String lastname;
    @XmlElement(name="Vorname")
    private String firstname;
    @XmlElement(name = "Klasse")
    private String classname;
    @XmlElement(name = "Schüler")
    private String size;
    @XmlElement(name = "Raum")
    private String room;
}
