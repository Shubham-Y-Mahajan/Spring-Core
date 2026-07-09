package com.shubham.spring.D_JavaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class Bike implements Vehicle {
    @Autowired
    @Qualifier("ceat")
    private Tyre tyre;

    public void setColor(String color) {
        this.color = color;
    }

    private String color;

    public void drive(){
        System.out.println("Bike is driving");
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
        return "Bike{" +
                "tyre=" + tyre +
                ", color='" + color + '\'' +
                '}';
    }
}
