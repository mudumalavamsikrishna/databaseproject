package com.vamsi.database.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/*@SpringBootApplication
@EntityScan("com.vamsi.database.bean")*/
public class JpaDemoApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(JpaDemoApplication.class);

	@Autowired
	PersonJpaRepository dao;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * logger.info("a particular user  -> {}", dao.findById(2));
		 * 
		 * logger.info("inserting data   -> {}", dao.insert(new Person(13, "jaya",
		 * "Chenni", new Date()))); logger.info("updating data -> {}", dao.update(new
		 * Person(4, "balu", "karanataka", new Date())));
		 * 
		 * dao.deleteById(1);
		 */

		logger.info("All Users -> {}", dao.findAll());

	}
}
