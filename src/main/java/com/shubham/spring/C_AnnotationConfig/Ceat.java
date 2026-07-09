package com.shubham.spring.C_AnnotationConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Ceat implements Tyre {
    @Value("5")
    private int life;


    @Override
    public String toString() {
        return "Ceat{" +
                "life=" + life +
                '}';
    }



}
