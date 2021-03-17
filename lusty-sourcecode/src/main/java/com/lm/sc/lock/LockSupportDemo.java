package com.lm.sc.lock;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("线程t1 park");
            LockSupport.park();

        });
        LockSupport.unpark(t1);
        t1.start();
        Thread.sleep(1000);
        LockSupport.unpark(t1);
        System.out.println("线程t1 解除park");
    }
}
