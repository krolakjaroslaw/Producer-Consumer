package com.pjatk.tasks.prodcons;

import java.util.Arrays;

public class Consumer extends Thread {

    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            if(!buffer.empty) {
                System.out.println("Consumer consumed number " + buffer.get() + " from position: " + (buffer.getIndex()+1)
                + ", occupancy: " + buffer.getCount());
                System.out.println("Buffer: " + Arrays.toString(buffer.getBuffer()));
            }

            try {
                int time = (int)(Math.random()*2000);
                this.sleep(time);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}