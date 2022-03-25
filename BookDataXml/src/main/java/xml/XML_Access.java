package xml;

import jakarta.xml.bind.JAXB;
import pojos.Author;
import pojos.Book;
import pojos.Publisher;
import pojos.PublisherList;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/*
    Created by: Jonas Seidl
    Date: 25.03.2022
    Time: 11:20
*/
public class XML_Access {

    private static Path filepath = Paths.get("src", "main", "resources", "books.xml");

    public static List<Publisher> readData() {
        List<Publisher> publishers = JAXB.unmarshal(filepath.toFile(), PublisherList.class).getPublishers();

        publishers.forEach(p -> p.getBooks().forEach(b -> b.setPublisher(p)));

        Set<Author> authorSet = new HashSet<>();
        publishers.forEach(p -> p.getBooks().forEach(
                b -> authorSet.addAll(b.getAuthors()))
        );
        publishers.forEach(p -> p.getBooks().forEach(
                b -> b.setAuthors(b.getAuthors().stream().filter(authorSet::contains).collect(Collectors.toList()))
        ));
        authorSet.forEach(a -> publishers.forEach(
                p -> p.getBooks().forEach(
                        b -> {
                            if (b.getAuthors().contains(a)) {
                                a.getBooks().add(b);
                            }}
                )));
        return publishers;
    }
}
