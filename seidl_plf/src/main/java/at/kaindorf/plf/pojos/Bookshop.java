package at.kaindorf.plf.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "bookShop")
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Bookshop
{

  @XmlElementWrapper(name="publisherlist")
  @XmlElement(name="publisher")
  private List<Publisher> publishers = new ArrayList<>();
}
