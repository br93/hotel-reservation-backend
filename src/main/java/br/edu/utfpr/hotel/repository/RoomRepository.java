package br.edu.utfpr.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.hotel.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
