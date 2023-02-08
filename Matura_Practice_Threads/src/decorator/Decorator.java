package decorator;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 09:31
*/
public abstract class Decorator extends Component{

    protected Component component;

    public Decorator(Component component){
        this.component = component;
    }
}
