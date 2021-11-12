package at.kaindorf.plf.pojos;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Book
{
  @NonNull
  @Id
  @Column(name="book_id")
  @XmlElement(name="bookId")
  private Integer bookId;

  @NonNull
  @Column(name="title", length = 255)
  @XmlElement(name="title")
  private String title;

  @NonNull
  @Column(name="isbn", length = 255)
  @XmlElement(name="isbn")
  private String isbn;

  @NonNull
  @Column(name="price", length = 38)
  @XmlElement(name="price")
  private double price;

  @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
  @XmlElementWrapper(name="authorlist")
  @XmlElement(name="author")
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Set<Author> authors = new HashSet<>();

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="publisher_id")
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Publisher publisher;

  public void addAuthor(Author a){
    authors.add(a);
    a.addBook(this);
  }
}
