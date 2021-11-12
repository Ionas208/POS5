package at.kaindorf.plf.pojos;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
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
@NamedQueries({
        @NamedQuery(name="getAllAuthorsOfPublisher", query = "SELECT DISTINCT a FROM Publisher p join p.books b join b.authors " +
                "a WHERE p.name = :publisher"),
        @NamedQuery(name = "getCountBookOfAuthor", query = "SELECT COUNT(a.books) FROM Author a " +
                "WHERE a.firstname = :firstname AND a.lastname = :lastname")
})

public class Author
{
  @Id
  @GeneratedValue
  @Column(name="author_id")
  @XmlTransient
  private Integer authorId;

  @NonNull
  @Column(name="firstname", length = 100)
  @XmlElement(name="firstname")
  private String firstname;

  @NonNull
  @Column(name="lastname", length = 255)
  @XmlElement(name="lastname")
  private String lastname;


  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
          name = "book_author",
          joinColumns = {
                  @JoinColumn(name="book")
          },
          inverseJoinColumns = {
                  @JoinColumn(name="author")
          }
  )
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Set<Book> books = new HashSet<>();

  public void addBook(Book b){
    books.add(b);
  }
}
