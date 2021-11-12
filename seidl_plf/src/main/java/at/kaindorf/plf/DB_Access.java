package at.kaindorf.plf;

import at.kaindorf.plf.pojos.Author;
import at.kaindorf.plf.pojos.Book;
import at.kaindorf.plf.pojos.Publisher;
import at.kaindorf.plf.pojos.Bookshop;

import javax.persistence.*;
import javax.xml.bind.JAXB;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DB_Access
{
  private static DB_Access instance = null;

  private Path filepath = Paths.get(System.getProperty("user.dir"), "src", "main",
          "resources", "booksdb.xml");

  private EntityManagerFactory emf = null;
  private EntityManager em = null;

  public static DB_Access getInstance(){
    if(instance == null){
      instance = new DB_Access();
    }
    return instance;
  }

  private DB_Access()
  {
  }

  private void connect(){
    emf = Persistence.createEntityManagerFactory("BooksDB_PU");
    em = emf.createEntityManager();
  }

  private void disconnect()
  {
    if(em != null){
      em.close();
      if(emf != null){
        emf.close();
      }
    }
  }

  private void loadBooksDB(){
    List<Publisher> publishers = JAXB.unmarshal(filepath.toFile(), Bookshop.class).getPublishers();
    Set<Book> uniqueBooks = new HashSet<>();
    Set<Author> uniqueAuthors = new HashSet<>();
    for (Publisher p: publishers)
    {
      Set<Book> booksOfPublisher = new HashSet<>(p.getBooks());
      p.setBooks(new HashSet<>());
      for (Book b: booksOfPublisher)
      {
        if(uniqueBooks.contains(b)){
          for (Book ub: uniqueBooks)
          {
            if(b.equals(ub)){
              b = ub;
            }
          }
        }else{
          uniqueBooks.add(b);
        }
        p.addBook(b);

        Set<Author> authorsOfBook = b.getAuthors();
        b.setAuthors(new HashSet<>());
        for (Author a: authorsOfBook)
        {
          if(uniqueAuthors.contains(a)){
            for (Author ua: uniqueAuthors)
            {
              if(a.equals(ua)){
                a = ua;
              }
            }
          }else{
            uniqueAuthors.add(a);
          }
          b.addAuthor(a);
        }
      }
    }

    /*for (Book b: uniqueBooks) {
      Set<Author> newAuthors = new HashSet<>();
      for (Author authorOfBook: b.getAuthors()) {
        if(uniqueAuthors.contains(authorOfBook)){
          for (Author ua: uniqueAuthors)
          {
            if(authorOfBook.equals(ua)){
              authorOfBook = ua;
            }
          }
        }else{
          System.out.println("shouldnt be called");
          //uniqueAuthors.add(authorOfBook);
        }
        newAuthors.add(authorOfBook);
      }
      b.setAuthors(newAuthors);
    }*/

    System.out.println("Unique Publishers: "+(new HashSet<>(publishers)).size());
    System.out.println("Unique Books: "+ uniqueBooks.size());
    System.out.println("Unique Authors: "+ uniqueAuthors.size());

    em.getTransaction().begin();
    for (Publisher p: (new HashSet<>(publishers))){
      em.persist(p);
    }
    em.getTransaction().commit();

  }

  private List<Author> getAllAuthorsOfPublisher(String publisher){
    Query q = em.createNamedQuery("getAllAuthorsOfPublisher");
    q.setParameter("publisher",publisher);
    List<Author> authors = q.getResultList();
    return authors;
  }

  private int getCountBookOfAuthor(String firstname, String lastname){
    Query q = em.createNamedQuery("getCountBookOfAuthor");
    q.setParameter("firstname",firstname);
    q.setParameter("lastname",lastname);
    Integer count = Integer.parseInt(q.getSingleResult()+"");
    return count;
  }

  public static void main(String[] args)
  {
    DB_Access dba = new DB_Access();
    dba.connect();
    dba.loadBooksDB();
    for (Author a: dba.getAllAuthorsOfPublisher("IDG Books"))
    {
      System.out.println(a);
    }
    System.out.println("Number of books: "+dba.getCountBookOfAuthor("Ed", "Tittel"));
    dba.disconnect();
  }
}
