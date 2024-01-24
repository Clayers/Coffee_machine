package com.example.coffee_machine.service;

import com.example.coffee_machine.entity.CoffeeEntity;
import com.example.coffee_machine.entity.SugarEntity;
import com.example.coffee_machine.repository.SugarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SugarService {
    @Autowired

    private SugarRepository sugarRepository;

    public SugarEntity getSugarById(Long id){
        return sugarRepository.findById(id)
                .orElse(null);
    }


    public Iterable<SugarEntity> getSugars() {
        return sugarRepository.findAll();
    }

    public SugarEntity addSugar(SugarEntity sugarEntity) {
        return sugarRepository.save(sugarEntity);
    }

    public SugarEntity deleteSugarById(Long id) {
        SugarEntity sugarEntity  = sugarRepository.findById(id)
                .orElse(null);
        if (sugarEntity!= null){
            sugarRepository.deleteById(id);
            return sugarEntity;
        }
        return sugarEntity;
    }
}
