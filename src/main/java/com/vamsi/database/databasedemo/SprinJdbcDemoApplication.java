package com.vamsi.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.vamsi.database.bean.Person;
import com.vamsi.database.jdbc.PersonJdbcDao;

//@SpringBootApplication
//@EntityScan("com.vamsi.database.bean")
//@ComponentScan({ "com.vamsi.database" })
public class SprinJdbcDemoApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(SprinJdbcDemoApplication.class);

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SprinJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("All Users -> {}", dao.findAll());
		logger.info("a particular user  -> {}", dao.findById(1));
		logger.info(" Deleting a particular user  -> {}", dao.delecteById(1));
		logger.info("inserting data   -> {}", dao.insert(new Person(11, "jaya", "Chenni", new Date())));
		logger.info("updating data -> {}", dao.update(new Person(2, "balu", "gunter", new Date())));
	}
}
