package com.test.web.core;

import com.test.web.api.entity.AccessBean;
import com.test.web.core.dao.AccessDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackageClasses = {AccessBean.class})
@EnableJpaRepositories(basePackageClasses = {AccessDao.class})
public class AccessApplication extends SpringBootServletInitializer {

	private static final Logger logger = LoggerFactory.getLogger(AccessApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AccessApplication.class);
	}

}
