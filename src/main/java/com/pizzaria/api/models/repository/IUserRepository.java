package com.pizzaria.api.models.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzaria.api.models.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
