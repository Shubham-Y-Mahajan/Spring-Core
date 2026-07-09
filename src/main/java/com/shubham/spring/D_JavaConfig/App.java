package com.shubham.spring.D_JavaConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        /// Goal is to create a Vehicle and fit its tyres

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Vehicle vehicle = (Vehicle)context.getBean("vehicle");
        /*
        This is most similar to XmlConfig in sense that everything is centrally created
        there no component scanning is involved so @Components were deleted
        However setters were necessary just like xmlconfig
         */

        vehicle.drive();
        System.out.println(vehicle);

    }
}
