package com.example.coffee_machine.service;

import com.example.coffee_machine.entity.CoffeeEntity;
import com.example.coffee_machine.entity.HistoryCoffeeMachineEntity;
import com.example.coffee_machine.entity.SugarEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class CoffeeMachineService {
    @Autowired
    HistoryCoffeeMachineService historyCoffeeMachineService = new HistoryCoffeeMachineService();
    @Autowired
    CoffeeService coffeeService;
    @Autowired
    SugarService sugarService;
    @Autowired
    MessageService messageService;
    public String CreateCofee(Long idCoffee, Long idSugar) {
        HistoryCoffeeMachineEntity historyCoffeeMachine= historyCoffeeMachineService.getHistoryCoffeeMachineLast();

        if (!historyCoffeeMachine.isNutrition())
        {

            return "Кофемашина выключена";
        }
        else
        {

           SugarEntity sugarEntity = sugarService.getSugarById(idSugar);
           CoffeeEntity coffeeEntity =  coffeeService.getCoffeeById(idCoffee);
           if (coffeeEntity.getMilk()) {
               if (historyCoffeeMachine.getMilk() > 0) {
                   historyCoffeeMachine.setMilk(historyCoffeeMachine.getMilk() - 20);
               } else return "Нет молока";
           }

            if ((historyCoffeeMachine.getCoffee() - coffeeEntity.getCoffee()) > 0) {
                historyCoffeeMachine.setCoffee(historyCoffeeMachine.getCoffee() - coffeeEntity.getCoffee());
            } else return "Нет кофе";

            if ((historyCoffeeMachine.getWater() -coffeeEntity.getWater()) > 0) {
                historyCoffeeMachine.setCoffee(historyCoffeeMachine.getWater() -coffeeEntity.getWater());
            } else return "Нет Воды";

            if ((historyCoffeeMachine.getPollution() -coffeeEntity.getPollution()) > 0) {
                historyCoffeeMachine.setCoffee(historyCoffeeMachine.getPollution() -coffeeEntity.getPollution());
            } else return "Кофе машина загрезнена";

            historyCoffeeMachine.setDateUse(new Date());
            historyCoffeeMachine.setCoffeeEntity(coffeeEntity);
            historyCoffeeMachine.setSugarEntity(sugarEntity);
            historyCoffeeMachine.setAction("Налито кофе");

            historyCoffeeMachineService.addHistoryCoffeeMachine(historyCoffeeMachine);

            return messageService.createMessagehistory( historyCoffeeMachine);

        }

    }

    public String checkInfo() {
        HistoryCoffeeMachineEntity historyCoffeeMachine;

        if(historyCoffeeMachineService.getHistoryCoffeeMachineFirst())
        {
            historyCoffeeMachine = new HistoryCoffeeMachineEntity(1L,
                    "Покупка",
                    new Date(),
                    false,
                    (CoffeeEntity) null,
                    (SugarEntity) null,
                    (double) 0,
                    (double) 0,
                    (double) 0,
                    (double) 0);
            historyCoffeeMachineService.addHistoryCoffeeMachine(historyCoffeeMachine);
        }
        return messageService.createMessagehistory(historyCoffeeMachineService.getHistoryCoffeeMachineLast());
    }

    public String OnOff() {
        HistoryCoffeeMachineEntity historyCoffeeMachine= historyCoffeeMachineService.getHistoryCoffeeMachineLast();
        if (historyCoffeeMachine.isNutrition())
        {
            historyCoffeeMachine.setNutrition(false);
            historyCoffeeMachine.setDateUse(new Date());
            historyCoffeeMachine.setCoffeeEntity(null);
            historyCoffeeMachine.setSugarEntity(null);
            historyCoffeeMachine.setAction("Включение");

            historyCoffeeMachineService.addHistoryCoffeeMachine(historyCoffeeMachine);

            return "Кофемашина выключена";
        }
        else
        {
            historyCoffeeMachine.setNutrition(true);
            historyCoffeeMachine.setDateUse(new Date());
            historyCoffeeMachine.setCoffeeEntity(null);
            historyCoffeeMachine.setSugarEntity(null);
            historyCoffeeMachine.setAction("Включение");

            historyCoffeeMachineService.addHistoryCoffeeMachine(historyCoffeeMachine);

            return "Кофемашина включена";
        }
    }

    public String coffeeMachineClear() {
        HistoryCoffeeMachineEntity historyCoffeeMachine= historyCoffeeMachineService.getHistoryCoffeeMachineLast();
        if(historyCoffeeMachine.getPollution()==1000){return "Кофемашина чистая";}
        else {
            historyCoffeeMachine.setPollution((double)1000);
            historyCoffeeMachine.setDateUse(new Date());
            historyCoffeeMachine.setCoffeeEntity(null);
            historyCoffeeMachine.setSugarEntity(null);
            historyCoffeeMachine.setAction("Чистка Кофе машины");

            historyCoffeeMachineService.addHistoryCoffeeMachine(historyCoffeeMachine);

            return messageService.createMessagehistory(historyCoffeeMachine);
        }
    }

    public String coffeeMachineFillWatter() {
        HistoryCoffeeMachineEntity historyCoffeeMachine= historyCoffeeMachineService.getHistoryCoffeeMachineLast();
        if(historyCoffeeMachine.getWater()==1000){return "Контейнер с водой наполнен";}
        else {
            historyCoffeeMachine.setWater((double)1000);
            historyCoffeeMachine.setDateUse(new Date());
            historyCoffeeMachine.setCoffeeEntity(null);
            historyCoffeeMachine.setSugarEntity(null);
            historyCoffeeMachine.setAction("Заполнение Воды");

            historyCoffeeMachineService.addHistoryCoffeeMachine(historyCoffeeMachine);

            return messageService.createMessagehistory(historyCoffeeMachine);
        }
    }

    public String coffeeMachineFillMilk() {
        HistoryCoffeeMachineEntity historyCoffeeMachine= historyCoffeeMachineService.getHistoryCoffeeMachineLast();
        if(historyCoffeeMachine.getMilk()==1000){return "Контейнер с молоком наполнен";}
        else {
            historyCoffeeMachine.setMilk((double)1000);
            historyCoffeeMachine.setDateUse(new Date());
            historyCoffeeMachine.setCoffeeEntity(null);
            historyCoffeeMachine.setSugarEntity(null);
            historyCoffeeMachine.setAction("Заполнение молоком");

            historyCoffeeMachineService.addHistoryCoffeeMachine(historyCoffeeMachine);

            return messageService.createMessagehistory(historyCoffeeMachine);
        }
    }

    public String coffeeMachineFillCoffee() {
        HistoryCoffeeMachineEntity historyCoffeeMachine= historyCoffeeMachineService.getHistoryCoffeeMachineLast();
        if(historyCoffeeMachine.getCoffee()==1000){return "Контейнер с кофе наполнен";}
        else {
            historyCoffeeMachine.setCoffee((double)1000);
            historyCoffeeMachine.setDateUse(new Date());
            historyCoffeeMachine.setCoffeeEntity(null);
            historyCoffeeMachine.setSugarEntity(null);
            historyCoffeeMachine.setAction("Заполнение Кофе");

            historyCoffeeMachineService.addHistoryCoffeeMachine(historyCoffeeMachine);

            return messageService.createMessagehistory(historyCoffeeMachine);
        }
    }
}
