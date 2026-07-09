package com.shubham.spring.D_JavaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Vehicle vehicle() {
        Vehicle v=new Car();
        v.setColor("black");
        return v; // Change Bike and Car here (centralised)
    }

    @Bean
    public Tyre mrfTyre() { //method name = name of bean created
        Tyre t=new MRF();
        t.setLife(7);
        return t;
    }

    @Bean
    public Tyre ceat() {
        Tyre t=new Ceat();
        t.setLife(5);
        return t;
    }


}
///Define Beans here instead of xml file
/// No component scan just like XML Config