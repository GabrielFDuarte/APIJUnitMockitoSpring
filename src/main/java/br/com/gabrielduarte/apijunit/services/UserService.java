package br.com.gabrielduarte.apijunit.services;

import java.util.List;

import br.com.gabrielduarte.apijunit.domain.Person;
import br.com.gabrielduarte.apijunit.domain.dto.UserDTO;

public interface UserService {

	Person findById(Integer id);
	List<Person> findAll();
	Person create(UserDTO obj);
	Person update(UserDTO obj);
}
