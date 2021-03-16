package com.lusty.example.service;

import org.springframework.stereotype.Service;

@Service
public class FatherService implements IPrint{

    @Override
    public void print() {
        System.out.println("this is FatherService");
    }
}
