package com.example;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ReminderManager {
    private ExecutorService executorService;
    public ReminderManager(int maxThreads) {
        this.executorService = Executors.newFixedThreadPool(maxThreads);
    }
    public void scheduleReminder(String message, int delayInSeconds){
        ReminderTask task = new ReminderTask(message, delayInSeconds);
        executorService.execute(task);
        System.out.println("Scheduled reminder: " + message + " in " + delayInSeconds + " seconds.");
    }
    public void ShutDown(){
        executorService.shutdown();
    }
    public static void main(String[] args) {
        ReminderManager reminderManager = new ReminderManager(3);
        reminderManager.scheduleReminder("Meeting with a team", 10);
        reminderManager.scheduleReminder("Take a break", 5);
        reminderManager.scheduleReminder("Submit report", 15);
        reminderManager.ShutDown();
    }
}