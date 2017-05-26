package com.pjatk.tasks.prodcons;

import java.util.Arrays;

public class Producer extends Thread {

    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            int number = (int)(Math.random()*100+1);

            if(!buffer.full) {
                buffer.put(number);
                System.out.println("Producer produced number " + number + " and put it on position: " + (buffer.getIndex()+1)
                + ", occupancy: " + buffer.getCount());
                System.out.println("Buffer: " + Arrays.toString(buffer.getBuffer()));
            }

            try {
                int time = (int)(Math.random()*2000);
                this.sleep(time);
            } catch (InterruptedException exc) {
                return;
            }
        }
    }
}