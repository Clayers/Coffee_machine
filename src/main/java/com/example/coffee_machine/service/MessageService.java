package com.example.coffee_machine.service;

import com.example.coffee_machine.entity.HistoryCoffeeMachineEntity;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    String messege;

    public String createMessagehistory(HistoryCoffeeMachineEntity historyCoffeeMachine)
    {
        if(historyCoffeeMachine.getCoffeeEntity()==null)
        {
            return "Питание: "+ historyCoffeeMachine.isNutrition()+
                    "\nДействие: "+ historyCoffeeMachine.getAction()+
                    "\nДата: "+ historyCoffeeMachine.getDateUse()+
                    "\nПоследнее кофе: нет"+
                    "\nСахар: нет"+
                    "\nВода: "+ historyCoffeeMachine.getWater()+
                    "\nКофе: "+ historyCoffeeMachine.getCoffee()+
                    "\nМолоко: "+ historyCoffeeMachine.getMilk()+
                    "\nЗагрязнение: "+ historyCoffeeMachine.getPollution();
        }
        else
        {
          return "Питание: "+ historyCoffeeMachine.isNutrition()+
                    "\nДействие: "+ historyCoffeeMachine.getAction()+
                    "\nДата: "+ historyCoffeeMachine.getDateUse()+
                    "\nПоследнее кофе: "+historyCoffeeMachine.getCoffeeEntity().getNameCoffee()+
                    "\nСахар: "+historyCoffeeMachine.getSugarEntity().getDescription()+
                    "\nВода: "+ historyCoffeeMachine.getWater()+
                    "\nКофе: "+ historyCoffeeMachine.getCoffee()+
                    "\nМолоко: "+ historyCoffeeMachine.getMilk()+
                    "\nЗагрязнение: "+ historyCoffeeMachine.getPollution();
        }

    }
    public String createMessageStatus(HistoryCoffeeMachineEntity historyCoffeeMachine)
    {

        return "Питание: "+ historyCoffeeMachine.isNutrition()+
                    "\nВода: "+ historyCoffeeMachine.getWater()+
                    "\nКофе: "+ historyCoffeeMachine.getCoffee()+
                    "\nМолоко: "+ historyCoffeeMachine.getMilk()+
                    "\nЗагрязнение: "+ historyCoffeeMachine.getPollution();

    }




}
