package br.com.gabrielduarte.apijunit.resources;

import static org.junit.jupiter.api.Assertions.*;

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
import br.com.gabrielduarte.apijunit.services.impl.UserServiceImpl;

@SpringBootTest
class UserResourceTest {
	
	private static final int INDEX = 0;
	private static final String PASSWORD = "123teste";
	private static final String EMAIL = "gabrielteste@email.com";
	private static final String NAME = "Gabriel Teste";
	private static final Integer ID = 1;
	
	@InjectMocks
	private UserResource resource;
	
	@Mock
	private UserServiceImpl service;
	
	@Mock
	private ModelMapper mapper;
	
	private Person user;
	private UserDTO userDTO;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		startPerson();
	}

	@Test
	void testFindById() {
		fail("Not yet implemented");
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
	}

}
