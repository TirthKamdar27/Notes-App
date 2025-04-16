package com.example;
public class ReminderTask implements Runnable {
    private String message;
    private int delayInSeconds;
    public ReminderTask(String message, int delayInSeconds) {
        this.message = message;
        this.delayInSeconds = delayInSeconds;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(delayInSeconds * 1000);
            System.out.println("Reminder: " + message);
        } catch (InterruptedException e) {
            System.out.println("Reminder interrupted: " + message);
        }
    }
}

