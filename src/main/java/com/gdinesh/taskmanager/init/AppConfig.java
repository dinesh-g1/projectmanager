package com.gdinesh.taskmanager.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public BeanA beanA() {
		return new BeanA();
	}
	
	@Bean(initMethod = "initializeB")
	public BeanB beanB() {
		return new BeanB();
	}
}
