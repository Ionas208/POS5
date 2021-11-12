package at.kaindorf.plf.pojos;


import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Publisher
{
  @Id
  @Column(name="publisher_id")
  @NonNull
  @XmlElement(name = "publisherId")
  private Integer publisherId;

  @NonNull
  @Column(name="name", length = 255)
  @XmlElement(name = "name")
  private String name;

  @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
  @XmlElementWrapper(name = "booklist")
  @XmlElement(name = "book")
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Set<Book> books;

  public void addBook(Book b){
    books.add(b);
    b.setPublisher(this);
  }
}
