package com.example.coffee_machine.repository;

import com.example.coffee_machine.entity.CoffeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<CoffeeEntity,Long> {

}
