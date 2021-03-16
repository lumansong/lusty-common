package com.lm.sc.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Main {



    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        long address = unsafe.staticFieldOffset(Demo.class.getDeclaredField("a"));
        int anInt = unsafe.getInt(Demo.class, address);
        unsafe.compareAndSwapInt(Demo.class,address,anInt,anInt+1);
        System.out.println(unsafe.getInt(Demo.class, address));
    }
}
