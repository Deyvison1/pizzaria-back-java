package com.pizzaria.api.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzaria.api.models.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

}
