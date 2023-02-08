package visitor;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 19:37
*/
public interface Visitor {
    void visit(ConcreteElementA element);
    void visit(ConcreteElementB element);
}
