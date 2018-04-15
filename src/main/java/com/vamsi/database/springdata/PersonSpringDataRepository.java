package com.vamsi.database.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vamsi.database.bean.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {

}
