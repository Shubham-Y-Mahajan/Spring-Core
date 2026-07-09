package com.shubham.spring.A_XMLConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        /// Goal is to create a Vehicle and fit its tyres

        ApplicationContext context = new ClassPathXmlApplicationContext("A_PureXML.xml");

        Vehicle vehicle = (Vehicle)context.getBean("vehicle"); //Type casted as .getBean returns type Object
        vehicle.drive();
        System.out.println(vehicle);
        // Values for Vehicle and Tyre set in XML file
        // So you will only have to edit the xml file to switch between car and bike & MRF Ceat
        // editing java code means recompiling
        // editing xml is just saving edited file
    }
}
