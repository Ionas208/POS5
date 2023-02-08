package visitor;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 19:37
*/
public class ConcreteElementB extends Element{

    public ConcreteElementB() {

    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
