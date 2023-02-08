package decorator;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 09:34
*/
public class DecoratorMain {


    public static void main(String[] args) {
        Component c = new ConcreteDecorator(new ConcreteComponent());
        c.operate();
    }
}
