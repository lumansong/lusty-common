package com.lm.sc.listdemo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        A a1=new A(1,1L);
        A a2=new A(1,2L);
        A a3=new A(2,2L);
        A a4=new A(2,1L);
        List<A> as = sort_01(Arrays.asList(a1, a2, a3, a4));
//        System.out.println(as);
        Map<Integer, Optional<A>> max = max(as);
        System.out.println(max);
    }

    @Data
    @AllArgsConstructor
   static   class A{
        private int id;
        private Long time;

    }

    public static Map<Integer, Optional<A>> max(List<A> list) {
        Map<Integer, Optional<A>> updateTimeMap = list.stream().
                collect(Collectors.groupingBy(A::getId,
                        Collectors.maxBy(Comparator.comparing(A::getTime))));
        return updateTimeMap;
    }

    public static List<A> sort_01(List<A> list){
       return list.stream().sorted(Comparator.comparing(A::getId).thenComparing(A::getTime)).collect(Collectors.toList());
    }
}
