package threads;

import java.util.concurrent.Callable;

/*
    Created by: Jonas Seidl
    Date: 07.05.2022
    Time: 15:07
*/
public class CreateSomething implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(100);
        System.out.println("h");
        return "Your mom";
    }
}
