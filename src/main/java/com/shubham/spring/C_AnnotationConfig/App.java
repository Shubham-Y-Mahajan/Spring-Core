package com.shubham.spring.C_AnnotationConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        /// Goal is to create a Vehicle and fit its tyres

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        /*
        Only change from B_HybridAnnotationXML here, is that
        we wrote component-scan command in AppConfig instead of XML file

        It is recommended to not use Hybrid approach as that can create confusion
        (This is because in Hybrid approach you can define beans in xml also without using @Component
        and get it @Autowired, This is confusing for code reviewing)
         */

        vehicle.drive();
        System.out.println(vehicle);

    }
}
