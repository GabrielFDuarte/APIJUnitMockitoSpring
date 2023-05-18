package br.com.gabrielduarte.apijunit.services.impl;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.gabrielduarte.apijunit.domain.Person;
import br.com.gabrielduarte.apijunit.domain.dto.UserDTO;
import br.com.gabrielduarte.apijunit.repositories.UserRepository;
import br.com.gabrielduarte.apijunit.services.exceptions.ObjectNotFoundException;

@SpringBootTest
class UserServiceImplTest {
	
	private static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";
	private static final String PASSWORD = "123teste";
	private static final String EMAIL = "gabrielteste@email.com";
	private static final String NAME = "Gabriel Teste";
	private static final Integer ID = 1;

	@InjectMocks
	private UserServiceImpl service;
	
	@Mock
	private UserRepository repository;
	
	@Mock
	private ModelMapper mapper;
	
	private Person user;
	private UserDTO userDTO;
	private Optional<Person> optionalUser;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		startPerson();
	}

	@Test
	void whenFindByIdThenReturnAnUserInstance() {
		when(repository.findById(anyInt())).thenReturn(optionalUser);
		
		Person response = service.findById(ID);
		
		assertNotNull(response);
		assertEquals(Person.class, response.getClass());
		assertEquals(ID, response.getId());
		assertEquals(NAME, response.getName());
		assertEquals(EMAIL, response.getEmail());
	}
	
	@Test
	void whenFindByIdThenReturnAnObjectNotFoundException() {
		when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException(OBJETO_NAO_ENCONTRADO));
		
		try {
			service.findById(ID);
		} catch (Exception ex) {
			assertEquals(ObjectNotFoundException.class, ex.getClass());
			assertEquals(OBJETO_NAO_ENCONTRADO, ex.getMessage());
		}
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}
	
	private void startPerson() {
		user = new Person(ID, NAME, EMAIL, PASSWORD);
		userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
		optionalUser = Optional.of(new Person(ID, NAME, EMAIL, PASSWORD));
	}
}
