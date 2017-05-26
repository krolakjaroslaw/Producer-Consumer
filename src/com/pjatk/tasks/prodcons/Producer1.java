package com.pjatk.tasks.prodcons;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

public class Producer1 implements Runnable {

    private BlockingQueue<Numbers> queue;

    public Producer1(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            int number = (int)(Math.random()*100+1);
            Numbers num = new Numbers(number);
            try {
                queue.put(num);
                System.out.println("Producer produced number " + number + ", occupancy: " + queue.size());
                System.out.println("Queue: " + Arrays.toString(queue.toArray()));
                int time = (int)(Math.random()*2000);
                Thread.sleep(time);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}