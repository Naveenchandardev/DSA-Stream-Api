package com.practice.dsa.stream.multithreading;

public class MyClass implements Runnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyClass());
        Thread t2 = new Thread(new MyClass());
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
