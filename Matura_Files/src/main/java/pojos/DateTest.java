package pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.xml.bind.JAXB;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import json.LocalDateDeserializer;
import json.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xml.LocalDateAdapter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 11:57
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "DateTest")
@XmlAccessorType(XmlAccessType.FIELD)
public class DateTest {
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @XmlElement(name = "date")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate date;

    public static void main(String[] args) {
        Path p = Paths.get("src", "main", "resources", "test.xml");
        //DateTest dt = JAXB.unmarshal(p.toFile(), DateTest.class);
        //System.out.println(dt);
        JAXB.marshal(new DateTest(LocalDate.now()), p.toFile());
    }
}
