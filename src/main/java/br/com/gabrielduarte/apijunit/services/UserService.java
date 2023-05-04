package br.com.gabrielduarte.apijunit.services;

import java.util.List;

import br.com.gabrielduarte.apijunit.domain.Person;

public interface UserService {

	Person findById(Integer id);
	List<Person> findAll();
}
