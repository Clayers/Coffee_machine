package com.example.coffee_machine.service;

import com.example.coffee_machine.entity.CoffeeEntity;
import com.example.coffee_machine.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CoffeeService {
    @Autowired

    private CoffeeRepository coffeeRepository;
    
    public CoffeeEntity getCoffeeById(Long id){
        return coffeeRepository.findById(id)
                .orElse(null);
    }

    public Iterable<CoffeeEntity> getCoffees() {
        return coffeeRepository.findAll();
    }

    public CoffeeEntity addCoffee(CoffeeEntity coffeeEntity) {
        return coffeeRepository.save(coffeeEntity);

    }

    public CoffeeEntity deleteCoffeeById(Long id) {
        CoffeeEntity coffeeEntity  = coffeeRepository.findById(id)
                .orElse(null);
        if (coffeeEntity!= null){
            coffeeRepository.deleteById(id);
            return coffeeEntity;
        }
        return coffeeEntity;
    }
}
