package com.pjatk.tasks.prodcons;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

public class Consumer1 implements Runnable {

    private BlockingQueue<Numbers> queue;

    public Consumer1(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Numbers num = queue.take();
                System.out.println("Consumer consumed number " + num.getNum() + ", occupancy: " + queue.size());
                System.out.println("Queue: " + Arrays.toString(queue.toArray()));
                int time = (int)(Math.random()*2000);
                Thread.sleep(time);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}