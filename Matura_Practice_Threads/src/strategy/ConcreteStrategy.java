package strategy;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 09:51
*/
public class ConcreteStrategy implements Strategy{
    @Override
    public void execute() {
        System.out.println("executing...");
    }
}
