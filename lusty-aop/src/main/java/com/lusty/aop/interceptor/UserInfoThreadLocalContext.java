package com.lusty.aop.interceptor;

import com.lusty.aop.bean.User;

/**
 * @author lumeng
 */
public class UserInfoThreadLocalContext {


    private static ThreadLocal<User> holder=new ThreadLocal<>();


    public static void addUser(User user){
        holder.set(user);
    }

    public static void remove(){
        holder.remove();
    }


    public static User getUser(){
        return holder.get();
    }



}
