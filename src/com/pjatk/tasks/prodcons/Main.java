package com.pjatk.tasks.prodcons;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) {

        Buffer buffer = new Buffer(10) ;
        Thread producer = new Producer(buffer);
        Thread consumer = new Consumer(buffer);

        producer.start();
        consumer.start();

        try {
            Thread.sleep(15000);

            consumer.interrupt();
            producer.interrupt();
        } catch (InterruptedException exc) {
            return;
        }

        System.out.println("\nProgram finished its action!");


        System.out.println("\n--------------------druga część zadania--------------------\n");


        BlockingQueue<Numbers> queue = new ArrayBlockingQueue<>(10);
        Thread producer1 = new Thread(new Producer1(queue));
        Thread consumer1 = new Thread(new Consumer1(queue));

        producer1.start();
        consumer1.start();

        try {
            Thread.sleep(15000);

            consumer1.interrupt();
            producer1.interrupt();
        } catch (InterruptedException exc) {
            return;
        }

        System.out.println("\nProgram finished its action!");
    }
}