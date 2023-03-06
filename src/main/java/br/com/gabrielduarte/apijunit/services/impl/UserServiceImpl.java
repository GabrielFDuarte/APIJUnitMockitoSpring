package br.com.gabrielduarte.apijunit.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrielduarte.apijunit.domain.Person;
import br.com.gabrielduarte.apijunit.repositories.UserRepository;
import br.com.gabrielduarte.apijunit.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public Person findById(Integer id) {
		Optional<Person> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
