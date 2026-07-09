package com.shubham.spring.A_XMLConfig;

public class MRF implements Tyre{
    private int life;

    public int getLife() {
        return life;
    }

    @Override
    public String toString() {
        return "MRF{" +
                "life=" + life +
                '}';
    }

    @Override
    public void setLife(int life) {
        this.life = life;
    }

}
