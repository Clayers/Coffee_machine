package com.example.coffee_machine.controller;

import com.example.coffee_machine.entity.CoffeeEntity;
import com.example.coffee_machine.service.CoffeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/coffee")
@Schema(description = "Контроллер Типов Кофе")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;
    @Operation(summary = "Получить тип кофе по id")
    @GetMapping (path = "{id}")
    @ResponseBody
    public CoffeeEntity getCoffee(@PathVariable("id") Long id)
    {
        return coffeeService.getCoffeeById(id);
    }

    @GetMapping
    @ResponseBody
    @Operation(summary = "Получить все типы кофе")
    public Iterable<CoffeeEntity> getAllCoffee()
    {
        return coffeeService.getCoffees();
    }

    @PutMapping
    @ResponseBody
    @Operation(summary = "Обноавить тип кофе")
    public CoffeeEntity updateCoffee(@RequestBody CoffeeEntity coffeeEntity)
    {
        return coffeeService.addCoffee(coffeeEntity);
    }

    @PostMapping
    @ResponseBody
    @Operation(summary = "Добавить тип кофе")
    public CoffeeEntity addCoffee(@RequestBody CoffeeEntity coffeeEntity)
    {
        return coffeeService.addCoffee(coffeeEntity);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseBody
    @Operation(summary = "Удалить тип кофе")
    public ResponseEntity<Long> deleteCoffee(@PathVariable("id")Long id)
    {
        var isRemoved = coffeeService.deleteCoffeeById(id);

        if (isRemoved == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);

    }


}
