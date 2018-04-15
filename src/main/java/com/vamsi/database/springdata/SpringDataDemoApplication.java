package com.vamsi.database.springdata;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.vamsi.database.bean.Person;

@SpringBootApplication
@EntityScan("com.vamsi.database.bean")
public class SpringDataDemoApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(SpringDataDemoApplication.class);

	@Autowired
	PersonSpringDataRepository dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("a particular user  -> {}", dao.findById(2));

		logger.info("inserting data   -> {}", dao.save(new Person("jaya", "Chenni", new Date())));
		logger.info("updating data -> {}", dao.save(new Person(1004, "chinna", "karanataka", new Date())));

		dao.deleteById(1002);

		logger.info("All Users -> {}", dao.findAll());

	}
}
