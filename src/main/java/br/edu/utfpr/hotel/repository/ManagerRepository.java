package br.edu.utfpr.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.hotel.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
