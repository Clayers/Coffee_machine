package com.example.coffee_machine.controller;

import com.example.coffee_machine.entity.CoffeeEntity;
import com.example.coffee_machine.entity.HistoryCoffeeMachineEntity;

import com.example.coffee_machine.service.HistoryCoffeeMachineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/history_coffee_machine")
public class HistoryCoffeeMachineController {
    @Autowired
    private HistoryCoffeeMachineService historyCoffeeMachineService;

    @GetMapping(path = "/{id}")
    @ResponseBody
    public HistoryCoffeeMachineEntity getHistoryCoffeeMachine(@PathVariable("id") Long id)
    {
        return historyCoffeeMachineService.getHistoryCoffeeMachineById(id);
    }

    @GetMapping
    @ResponseBody
    public Iterable<HistoryCoffeeMachineEntity> getAllHistoryCoffeeMachine()
    {
        return historyCoffeeMachineService.getHistoryCoffeeMachines();
    }


    @PutMapping
    @ResponseBody
    public HistoryCoffeeMachineEntity updateHistoryCoffeeMachine(@RequestBody HistoryCoffeeMachineEntity historyCoffeeMachine)
    {
        return historyCoffeeMachineService.addHistoryCoffeeMachine(historyCoffeeMachine);
    }

    @PostMapping
    @ResponseBody
    public HistoryCoffeeMachineEntity addHistoryCoffeeMachine(@RequestBody HistoryCoffeeMachineEntity historyCoffeeMachine)
    {
        return historyCoffeeMachineService.addHistoryCoffeeMachine(historyCoffeeMachine);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<Long> deleteHistoryCoffeeMachine(@PathVariable("history_coffee_machine/id") Long id)
    {
        var isRemoved = historyCoffeeMachineService.deleteHistoryCoffeeMachineById(id);

        if (isRemoved == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);

    }
}
