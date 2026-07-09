package com.shubham.spring.A_XMLConfig;

public class Bike implements Vehicle{
    private Tyre tyre;
    private String color;

    public Bike(Tyre tyre){
        this.tyre=tyre;
    }
    public void drive(){
        System.out.println("Bike is driving");
    }

    public String getColor() {
        return color;
    }

    @Override
    public Tyre getTyre() {
        return tyre;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "tyre=" + tyre +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }


}
