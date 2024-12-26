package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 1;
        });

        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 2;
        });

        CompletableFuture<Integer> task3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 3;
        });

        CompletableFuture<Object> firstCompleted = CompletableFuture.anyOf(task1, task2, task3);

        try {
            System.out.println("First completed task is: " + firstCompleted.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}