package br.com.javafx.labspring.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "br.com.javafx.labspring" })
public class SpringConfiguration {

	public static final ApplicationContext APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(
			SpringConfiguration.class);

}
