package br.com.gabrielduarte.apijunit.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gabrielduarte.apijunit.domain.Person;

@Repository
public interface UserRepository extends JpaRepository<Person, Integer> {

	Optional<Person> findByEmail(String email);

}
