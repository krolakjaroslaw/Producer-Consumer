package com.pjatk.tasks.prodcons;

public class Numbers {

    private int num;

    public Numbers(int num){
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "" + num;
    }
}