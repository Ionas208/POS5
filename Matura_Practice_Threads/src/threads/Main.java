package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;

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

        /*FutureTask<String> f = new FutureTask(new threads.CreateSomething());
        Thread t3 = new Thread(f);
        t3.start();
        try {
            System.out.println(f.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
        ExecutorService pool = Executors.newFixedThreadPool(10);
        ExecutorCompletionService<String> service = new ExecutorCompletionService<>(pool);
        for (int i = 0; i < 10; i++) {
            service.submit(new CreateSomething());
        }
        pool.shutdown();
        List<String> results = new ArrayList<>();
         while(!pool.isTerminated()){
            try {
                String result = service.take().get();
                System.out.println(result);
                results.add(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(results);
    }
}
