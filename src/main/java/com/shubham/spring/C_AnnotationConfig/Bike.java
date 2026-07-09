package com.shubham.spring.C_AnnotationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component //default name of created bean = decapitalized class name = "bike"
public class Bike implements Vehicle {
    @Autowired
    @Qualifier("ceat")
    private Tyre tyre;

    @Value("black")
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
