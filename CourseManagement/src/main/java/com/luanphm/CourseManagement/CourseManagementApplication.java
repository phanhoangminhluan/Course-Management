package com.luanphm.CourseManagement;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
@SpringBootApplication
public class CourseManagementApplication {
	private static final Logger logger = LoggerFactory.getLogger(CourseManagementApplication.class);
	public static void main(String[] args) throws IOException {
		SpringApplication.run(CourseManagementApplication.class, args);
//
//		logger.debug("Debugging log");
//		logger.info("Info log");
//		logger.warn("Hey, This is a warning!");
//		logger.error("Oops! We have an Error. OK");
	}
}
