package com.pizzaria.api.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzaria.api.models.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
