package state;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 10:00
*/
public class ConcreteState implements State{

    private Context context;

    public ConcreteState(Context context){
        this.context = context;
    }

    @Override
    public void operate() {
        System.out.println("operating...");
        //state über context eventuell verändern.
    }

}
