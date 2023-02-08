package visitor;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 19:37
*/
public abstract class Element {
    public abstract void accept(Visitor v);
}
