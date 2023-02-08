package strategy;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 09:51
*/
public class Context {
    public Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void execute(){
        strategy.execute();
    }

    public static void main(String[] args) {
        Context c = new Context(new ConcreteStrategy());
        c.execute();
    }
}
