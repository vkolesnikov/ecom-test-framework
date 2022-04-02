package io.ecom.ui;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.testng.TestNG;

@SpringBootApplication
@ComponentScan(value = {"io/ecom/ui/pageobjects", "io/ecom/ui/steps"})
@PropertySource(value = {"classpath:application.properties"})
public class SpringContextEntrypoint {

    public static void main(String[] args) throws Exception {
        TestNG.main(args);
    }

}
