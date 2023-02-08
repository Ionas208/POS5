package visitor;

import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 19:39
*/
public class Client {
    public static void main(String[] args) {
        List<Element> elements = new ArrayList<>();
        elements.add(new ConcreteElementA());
        elements.add(new ConcreteElementA());
        elements.add(new ConcreteElementA());
    }
}
