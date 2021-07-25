package br.edu.utfpr.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.hotel.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
