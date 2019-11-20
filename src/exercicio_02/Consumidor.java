package exercicio_02;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.PriorityBlockingQueue;

import static java.lang.Thread.sleep;

public class Consumidor implements Runnable {

    private final PriorityBlockingQueue<Carta> q;
    private CountDownLatch readyThreadCounter;

    Consumidor(PriorityBlockingQueue<Carta> queue, CountDownLatch readyThreadCounter) {

        this.q = queue;
        this.readyThreadCounter = readyThreadCounter;
    }

    @Override
    public void run() {
        boolean resume = true;
        try {
            readyThreadCounter.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (resume) {
            for (int i = 0; i < 3; i++) {

                Carta c = q.poll();
                if (c != null) c.print();
                else {
                    resume = false;
                    break;
                }
            }

            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
