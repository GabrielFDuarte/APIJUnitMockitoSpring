package br.com.gabrielduarte.apijunit.services;

import br.com.gabrielduarte.apijunit.domain.Person;

public interface UserService {

	Person findById(Integer id);
}
