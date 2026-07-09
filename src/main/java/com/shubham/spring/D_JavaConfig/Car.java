package com.shubham.spring.D_JavaConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class Car implements Vehicle {
    @Autowired
    @Qualifier("mrfTyre")
    private Tyre tyre;


    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    public void drive(){
        System.out.println("Car is driving");
    }

    @Override
    public Tyre getTyre() {
        return tyre;
    }

    @Override
    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    @Override
    public String toString() {
        return "Car{" +
                "tyre=" + tyre +
                ", color='" + color + '\'' +
                '}';
    }
}

