package threads;

import java.util.Queue;

/*
    Created by: Jonas Seidl
    Date: 07.05.2022
    Time: 14:52
*/
public class Consumer implements Runnable{

    private Queue<Integer> q;

    public Consumer(Queue q){
        this.q = q;
    }

    @Override
    public void run() {
        Thread.currentThread().isInterrupted();
        while(true){
            synchronized (q){
                if (q.isEmpty()){
                    try {
                        q.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Consume " + q.poll());
            }
        }
    }
}
