package decorator;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 09:31
*/
public class ConcreteDecorator extends Decorator{

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operate() {
        component.operate();
        System.out.println("concreted");
    }
}
