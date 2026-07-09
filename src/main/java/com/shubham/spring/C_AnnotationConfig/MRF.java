package com.shubham.spring.C_AnnotationConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mrfTyre") // setting custom name
public class MRF implements Tyre {
    @Value("7")
    private int life;



    @Override
    public String toString() {
        return "MRF{" +
                "life=" + life +
                '}';
    }



}
