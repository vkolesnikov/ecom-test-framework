package io.ecom.ui;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(value = {"io/ecom/ui/pageobjects", "io/ecom/ui/steps"})
@PropertySource(value = {"classpath:application.properties"})
public class GeneralUiConfiguration {

}
