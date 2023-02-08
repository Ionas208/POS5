package threads;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Callable;

/*
    Created by: Jonas Seidl
    Date: 07.05.2022
    Time: 14:52
*/
public class Producer implements Runnable, Callable<String>{

    private Queue<Integer> q;

    public Producer(Queue q){
        this.q = q;
    }

    @Override
    public void run() {
        while(true){
            Random rand = new Random();
            synchronized (q){
                int num = rand.nextInt(100);
                q.add(num);
                System.out.println("Produce "+num);
                q.notify();
            }
            try {
                Thread.sleep(rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String call() throws Exception {
        return null;
    }
}
