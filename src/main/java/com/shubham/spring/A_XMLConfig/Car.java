package com.shubham.spring.A_XMLConfig;

public class Car implements Vehicle{
    private Tyre tyre;
    private String color;

    public Car(Tyre tyre){
        this.tyre=tyre;
    }

    public void drive(){
        System.out.println("Car is driving");
    }

    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
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
