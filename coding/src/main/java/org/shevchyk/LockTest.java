package org.shevchyk;

import java.util.concurrent.locks.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 1 acquired lock");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
                System.out.println("Thread 1 released lock");
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                lock.unlock();
                System.out.println("Thread 2 released lock");
            } catch (IllegalMonitorStateException e) {
                System.out.println("Thread 2 could not release lock: " + e);
            }
        });

        thread1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        thread2.start();
    }
}
