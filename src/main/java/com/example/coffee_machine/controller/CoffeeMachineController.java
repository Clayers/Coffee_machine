package com.example.coffee_machine.controller;

import com.example.coffee_machine.entity.CoffeeEntity;
import com.example.coffee_machine.entity.HistoryCoffeeMachineEntity;
import com.example.coffee_machine.service.CoffeeMachineService;
import com.example.coffee_machine.service.CoffeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coffee_machina")
@Schema(description = "Контроллер Истории Кофе Машины")
public class CoffeeMachineController {

    @Autowired
    private CoffeeMachineService coffeeMachineService;

    @Operation(summary = "Заварить кофе")
    @GetMapping(path = "/{idCoffee}/{idSugar}")
    @ResponseBody
    public String createCoffee(@PathVariable Long idCoffee, @PathVariable Long idSugar)
    {
        return coffeeMachineService.CreateCofee(idCoffee,idSugar);
    }

    @GetMapping
    @ResponseBody
    @Operation(summary = "Получить информацию о коферварке")
    public String checkInfo()
    {
        return coffeeMachineService.checkInfo();
    }

    @GetMapping(path = "/coffee_machina/on_off")
    @ResponseBody
    @Operation(summary = "Вкл/Выкл")
    public String coffeeMachineOnOff()
    {
        return coffeeMachineService.OnOff();
    }

    @GetMapping(path = "/coffee_machina/clear")
    @ResponseBody
    @Operation(summary = "Очистить кофе машину")
    public String coffeeMachineClear()
    {
        return coffeeMachineService.coffeeMachineClear();
    }

    @GetMapping(path = "/coffee_machina/fill_coffe")
    @ResponseBody
    @Operation(summary = "Засыпать Кофе")
    public String coffeeMachineFillCoffee()
    {
        return coffeeMachineService.coffeeMachineFillCoffee();
    }
    @GetMapping(path = "/coffee_machina/fill_water")
    @ResponseBody
    @Operation(summary = "Залить Воды")
    public String coffeeMachineFillWatter()
    {
        return coffeeMachineService.coffeeMachineFillWatter();
    }
    @GetMapping(path = "/coffee_machina/fill_milk")
    @ResponseBody
    @Operation(summary = "Залить Молоко")
    public String coffeeMachineFillMilk()
    {
        return coffeeMachineService.coffeeMachineFillMilk();
    }
}
