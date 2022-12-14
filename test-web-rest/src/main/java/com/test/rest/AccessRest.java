package com.test.rest;

import com.test.web.core.AccessApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

public class AccessRest {

	private static final Logger logger = LoggerFactory.getLogger(AccessRest.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext cac = SpringApplication.run(AccessApplication.class, args);
		if(logger.isDebugEnabled()){
			String[] beanNames = cac.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for(String beanName: beanNames){
				logger.debug(beanName);
			}
		}
	}

}
