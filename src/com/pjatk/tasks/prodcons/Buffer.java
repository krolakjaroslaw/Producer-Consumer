package com.pjatk.tasks.prodcons;

public class Buffer {

    private int[] buffer;
    boolean full, empty;
    private int count, size, index;

    public Buffer(int size) {
        buffer = new int[size];
        this.size = size;
        full = false;
        empty = true;
    }

    public int[] getBuffer() {
        return buffer;
    }

    public int getCount() {
        return count;
    }

    public int getIndex() {
        return index;
    }

    public synchronized void put(int number) {
        while(full) {
            try {
                wait();
            } catch(InterruptedException exc) {
                System.out.println("Error! put => wait");
            }
        }

        for (int i=0; i<size; i++) {
            if (buffer[i] == 0) {
                index = i;
                break;
            }
        }
        buffer[index] = number;

        count++;
        if (count == size)
            full = true;

        empty = false;

        notify();
    }

    public synchronized int get() {
        while(empty) {
            try {
                wait();
            } catch(InterruptedException exc) {
                System.out.println("Error! get => wait");
            }
        }

        int number = buffer[0];
        index = 0;

        for (int i=0; i<size-1; i++) {
            buffer[i] = buffer[i+1];
        }

        count--;
        if (count == 0)
            empty = true;

        full = false;

        notify();

        return number;
    }
}