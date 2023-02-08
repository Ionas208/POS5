package visitor;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 19:37
*/
public class ConcreteVisitor1 implements Visitor {
    @Override
    public void visit(ConcreteElementA element) {
        // do something with element
    }

    @Override
    public void visit(ConcreteElementB element) {
        // do something with element
    }
}
