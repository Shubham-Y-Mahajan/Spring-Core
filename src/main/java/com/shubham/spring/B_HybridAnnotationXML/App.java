package com.shubham.spring.B_HybridAnnotationXML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        /// Goal is to create a Vehicle and fit its tyres

        ApplicationContext context = new ClassPathXmlApplicationContext("B_HybridAnnotationXML.xml");
        Vehicle vehicle = context.getBean(Vehicle.class);
        //Change car and bike using @Primary annotation
        // In this case xml file is just used to write the component scan statement
        // Notice how default values were set using @Value and used @Autowired to generate the bean
        // Also in Tyre we did not have to write setter
        //Observe how tyre was chosen in each vehicle clas using @Qualifier

        vehicle.drive();
        System.out.println(vehicle);

    }
}
