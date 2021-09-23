package at.kaindorf.customerdb.pojos;

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
    Date: 23.09.2021
    Time: 09:19
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name="customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerList {
    @XmlElement(name = "customer")
    private List<CustomerXML> customers = null;
}
