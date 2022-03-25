import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pojos.Author;
import pojos.Book;
import pojos.Publisher;
import xml.XML_Access;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
    Created by: Jonas Seidl
    Date: 25.03.2022
    Time: 11:58
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Main {
    private List<Publisher> publishers;

    public void task1() {
        System.out.println(publishers.stream().map(Publisher::getName).sorted().collect(Collectors.joining(", ")));
    }

    public void task2() {
        System.out.println(publishers.stream()
                .flatMap(p -> p.getBooks().stream()
                        .map(Book::getPrice))
                .mapToDouble(Double::doubleValue)
                .average()
                .getAsDouble());
    }

    public void task3() {
        System.out.println(publishers.stream()
                .flatMap(p -> p.getBooks().stream()
                        .map(Book::getPrice))
                .mapToDouble(Double::doubleValue)
                .sum());
    }

    public void task4() {
        System.out.println(
                publishers.stream()
                        .collect(Collectors.toMap(Publisher::getName, Publisher::getBooks))
        );

    }

    public void task5() {
        System.out.println(
                publishers.stream()
                        .collect(Collectors.toMap(Publisher::getName, p -> p.getBooks().stream()
                                .flatMap(b -> b.getAuthors().stream())
                                .collect(Collectors.toList())
                        ))
        );
    }

    public void task6(){
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();*/
        int number = 2;
        System.out.println(
                publishers.stream()
                        .flatMap(p -> p.getBooks().stream())
                        .filter(b -> b.getAuthors().size() != number)
                        .collect(Collectors.toList())
        );
    }

    public void task7(){
        System.out.println(
                publishers.stream()
                        .flatMap(p -> p.getBooks().stream())
                        .filter(b -> !b.getUrl().equals(""))
                        .collect(Collectors.toList())
        );
    }

    public void task8(){
        publishers.stream()
                .flatMap(p -> p.getBooks().stream())
                .forEach(b -> {
                    if(b.getPrice() >= 30){
                        b.setPrice(b.getPrice()-5);
                    }
                });
    }

    public void task9(){
        System.out.println(
                publishers.stream()
                        .flatMap(p -> p.getBooks().stream()
                                .flatMap(b -> b.getAuthors().stream().map(Author::getLastname))
                        .filter(a -> publishers.stream()
                                .flatMap(p1 -> p1.getBooks().stream()
                                        .filter(b1 -> b1.getAuthors().stream()
                                                .anyMatch(a1 -> a1.getLastname().equals(a))))
                                .map(Book::getPublisher)
                                .count() <= 1))
                        .collect(Collectors.toList()));
    }

    public void task10(){
        publishers.stream()
                .filter(p -> !(p.getId()+"").startsWith("1"))
                .forEach(p -> p.setId(
                        Integer.parseInt("2"+(p.getId()+"").substring(1))
                ));
    }

    public static void main(String[] args) {
        Main main = new Main(XML_Access.readData());
        main.task1();
        main.task2();
        main.task3();
        main.task4();
        main.task5();
        main.task6();
        main.task7();
        main.task8();
        main.task9();
        main.task10();
    }
}
