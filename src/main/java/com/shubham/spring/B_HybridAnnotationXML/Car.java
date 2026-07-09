package com.shubham.spring.B_HybridAnnotationXML;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Car implements Vehicle {
    @Autowired
    @Qualifier("mrfTyre")
    private Tyre tyre;

    @Value("black")
    private String color;

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

