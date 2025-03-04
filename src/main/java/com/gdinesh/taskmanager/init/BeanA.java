package com.gdinesh.taskmanager.init;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


public class BeanA {
	
	@PostConstruct
	public void beanA() {
		//Initializes the BeanA
	}
	
	@PreDestroy
	public void destroyA() {
		
	}
}
