package com.example.coffee_machine.service;


import com.example.coffee_machine.entity.HistoryCoffeeMachineEntity;
import com.example.coffee_machine.repository.HistoryCoffeeMachineRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@Slf4j
public class HistoryCoffeeMachineService {
    @Autowired

    private HistoryCoffeeMachineRepository historyCoffeeMachineRepository ;

    public HistoryCoffeeMachineEntity getHistoryCoffeeMachineById(Long id){
        return historyCoffeeMachineRepository.findById(id)
                .orElse(null);
    }
    public boolean getHistoryCoffeeMachineFirst(){

        HistoryCoffeeMachineEntity historyCoffeeMachineEntity = historyCoffeeMachineRepository.checkHistoryCoffeeMachineEntity();
           if (historyCoffeeMachineEntity == null)
           {
               return true;
           }
            return false;

    }

    public HistoryCoffeeMachineEntity getHistoryCoffeeMachineLast() {
        return historyCoffeeMachineRepository.getLastHistoryCoffeeMachineEntity();
    }
    public Iterable <HistoryCoffeeMachineEntity> getHistoryCoffeeMachines() {
        return historyCoffeeMachineRepository.findAll();
    }

    public HistoryCoffeeMachineEntity addHistoryCoffeeMachine(HistoryCoffeeMachineEntity historyCoffeeMachine) {
        return historyCoffeeMachineRepository.save(historyCoffeeMachine);
    }

    public HistoryCoffeeMachineEntity deleteHistoryCoffeeMachineById(Long id) {
        HistoryCoffeeMachineEntity historyCoffeeMachine  = historyCoffeeMachineRepository.findById(id)
                .orElse(null);
        if (historyCoffeeMachine!= null){
            historyCoffeeMachineRepository.deleteById(id);
            return historyCoffeeMachine;
        }
        return historyCoffeeMachine;
    }
}
