package com.shubham.spring.D_JavaConfig;


public class Ceat implements Tyre {

    private int life;

    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public String toString() {
        return "Ceat{" +
                "life=" + life +
                '}';
    }



}
