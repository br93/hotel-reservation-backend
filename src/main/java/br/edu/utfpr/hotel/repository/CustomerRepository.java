package br.edu.utfpr.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.hotel.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
