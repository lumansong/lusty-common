package com.lusty.example.service;

import org.springframework.stereotype.Service;


public class SonService extends FatherService implements IPrint{
    @Override
    public void print() {
        System.out.println("this is SonService");
    }
}
