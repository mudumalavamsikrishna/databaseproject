package com.vamsi.database.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.vamsi.database.bean.Person;

@Repository
public class PersonJdbcDao {

	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthdate(rs.getTimestamp("birthdate"));

			return person;
		}

	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Person> findAll() {

		// return jdbcTemplate.query("select * from Person", new
		// BeanPropertyRowMapper(Person.class));
		return jdbcTemplate.query("select * from Person", new PersonRowMapper());

	}

	public Person findById(int id) {

		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));

	}

	public int delecteById(int id) {

		return jdbcTemplate.update("delete from person where id=?", new Object[] { id });

	}

	public int insert(Person person) {

		return jdbcTemplate.update("insert into person (id,name, location, birthdate) values(?,?,?,?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(),
						new Timestamp(person.getBirthdate().getTime()) });

	}

	public int update(Person person) {

		return jdbcTemplate.update("update person set name= ?, location= ?, birthdate= ?  where id=? ",
				new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirthdate().getTime()),
						person.getId() });

	}

}
