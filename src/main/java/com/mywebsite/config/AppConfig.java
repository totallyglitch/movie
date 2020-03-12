package com.mywebsite.config;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("deprecation")
public class AppConfig extends ResourceConfig {
	private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

	public AppConfig() {

		packages("com.mywebsite.route");

		logger.info("Registered Logging Filter");
		register(LoggingFilter.class);

	}

}