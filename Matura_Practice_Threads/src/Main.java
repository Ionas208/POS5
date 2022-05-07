import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/*
    Created by: Jonas Seidl
    Date: 07.05.2022
    Time: 14:51
*/
public class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<>();
        Thread t1 = new Thread(new Producer(q));
        Thread t2 = new Thread(new Consumer(q));
        //t1.start();
        //t2.start();

        FutureTask<String> f = new FutureTask(new CreateSomething());
        Thread t3 = new Thread(f);
        t3.start();
        try {
            System.out.println(f.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
