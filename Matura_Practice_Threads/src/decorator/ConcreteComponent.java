package decorator;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 09:31
*/
public class ConcreteComponent extends Component{

    public ConcreteComponent(){

    }

    @Override
    public void operate() {
        System.out.println("concrete");
    }
}
