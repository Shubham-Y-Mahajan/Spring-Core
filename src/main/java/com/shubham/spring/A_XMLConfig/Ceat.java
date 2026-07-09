package com.shubham.spring.A_XMLConfig;

public class Ceat implements Tyre{
    private int life;

    public int getLife() {
        return life;
    }

    @Override
    public String toString() {
        return "Ceat{" +
                "life=" + life +
                '}';
    }

    @Override
    public void setLife(int life) {
        this.life = life;
    }

}
