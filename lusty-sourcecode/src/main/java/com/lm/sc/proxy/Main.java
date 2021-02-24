package com.lm.sc.proxy;

public class Main {

    public static void main(String[] args) {
        try {
            // 代理类class文件存入本地磁盘方便我们反编译查看源码  D:/$Proxy0.class
            A obj = (A)new AProxy().getInstance(A.class);
            System.out.println(obj.getClass());
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
