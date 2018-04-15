package com.vamsi.database.databasedemo;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vamsi.database.bean.Person;
import com.vamsi.database.jdbc.PersonJdbcDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SprinJdbcDemoApplicationTests {


	@Autowired
	PersonJdbcDao dao;

	@Test
	public void contextLoads() {

		assertEquals(1, dao.update(new Person(2, "balu", "gunter", new Date())));
	}

}
