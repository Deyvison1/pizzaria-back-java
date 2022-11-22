package com.pizzaria.api.models.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzaria.api.models.Item;

@Repository
public interface IItemRepository extends JpaRepository<Item, Long> {
	
	Optional<List<Item>> findByTableOrderId(Long id);
}
