package com.lm.sc.thread;

import java.util.concurrent.CompletableFuture;

public class CompleteFutureDemo {


    public static void main(String[] args) throws InterruptedException {

        CompletableFuture<String> c1 = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("返回c1");
            return "c1";
        });


        CompletableFuture<String> c2 = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("返回c2");
            return "c2";
        });

        System.out.println("Main");
        CompletableFuture.allOf(c1,c2).whenCompleteAsync((k,v)->{
            System.out.println(k);
            System.out.println(v);

        });

        Thread.sleep(5000);

    }
}
