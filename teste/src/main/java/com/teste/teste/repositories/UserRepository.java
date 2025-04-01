package com.teste.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.teste.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
