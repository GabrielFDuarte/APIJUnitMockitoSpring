package br.com.gabrielduarte.apijunit.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.gabrielduarte.apijunit.domain.Person;
import br.com.gabrielduarte.apijunit.repositories.UserRepository;

@Configuration
@Profile("local")
public class LocalConfig {
	
	@Autowired
	private UserRepository repository;

	@Bean
	public void startDB() {
		Person u1 = new Person(null, "Gabriel", "gabriel@email.com", "123");
		Person u2 = new Person(null, "Aline", "aline@email.com", "123");
		
		repository.saveAll(List.of(u1, u2));
	}
}
