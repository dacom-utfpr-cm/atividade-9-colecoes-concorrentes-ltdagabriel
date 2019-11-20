package exercicio_02;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.PriorityBlockingQueue;

public class Prudutor implements Runnable {
    Baralho b = new Baralho();
    private final PriorityBlockingQueue<Carta> q;
    private CountDownLatch readyThreadCounter;

    public Prudutor(PriorityBlockingQueue<Carta> q, CountDownLatch readyThreadCounter) {
        this.q = q;
        this.readyThreadCounter = readyThreadCounter;
    }

    @Override
    public void run() {
        while (!b.vazio()) {
            q.add(b.get());
            readyThreadCounter.countDown();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
