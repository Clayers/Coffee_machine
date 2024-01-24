package com.example.coffee_machine.controller;

import com.example.coffee_machine.entity.CoffeeEntity;
import com.example.coffee_machine.entity.HistoryCoffeeMachineEntity;
import com.example.coffee_machine.entity.SugarEntity;
import com.example.coffee_machine.service.HistoryCoffeeMachineService;
import com.example.coffee_machine.service.SugarService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sugar")
@Schema(name = "Контроллер Количества Сахара")
public class SugarController {
    @Autowired
    private SugarService sugarService;

    @GetMapping(path = "/{id}")
    @ResponseBody
    public SugarEntity getSugar(@PathVariable("id") Long id)
    {
        return sugarService.getSugarById(id);
    }

    @GetMapping
    @ResponseBody
    public Iterable<SugarEntity> getAllSugar()
    {
        return sugarService.getSugars();
    }

    @PutMapping
    @ResponseBody
    public SugarEntity updateSugar(@RequestBody SugarEntity sugarEntity)
    {
        return sugarService.addSugar(sugarEntity);
    }

    @PostMapping
    @ResponseBody
    public SugarEntity addSugar(@RequestBody SugarEntity sugarEntity)
    {
        return sugarService.addSugar(sugarEntity);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<Long> deleteSugar(@PathVariable("id") Long id)
    {
        var isRemoved = sugarService.deleteSugarById(id);

        if (isRemoved == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);

    }
}
