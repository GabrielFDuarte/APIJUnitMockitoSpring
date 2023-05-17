package br.com.gabrielduarte.apijunit.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrielduarte.apijunit.domain.Person;
import br.com.gabrielduarte.apijunit.domain.dto.UserDTO;
import br.com.gabrielduarte.apijunit.repositories.UserRepository;
import br.com.gabrielduarte.apijunit.services.UserService;
import br.com.gabrielduarte.apijunit.services.exceptions.DataIntegrityViolationException;
import br.com.gabrielduarte.apijunit.services.exceptions.ObjectNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Person findById(Integer id) {
		Optional<Person> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Person> findAll() {
		return repository.findAll();
	}

	@Override
	public Person create(UserDTO obj) {
		findByEmail(obj);
		return repository.save(mapper.map(obj, Person.class));
	}
	
	private void findByEmail(UserDTO obj) {
		Optional<Person> user = repository.findByEmail(obj.getEmail());
		if (user.isPresent()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema");
		}
	}
}
