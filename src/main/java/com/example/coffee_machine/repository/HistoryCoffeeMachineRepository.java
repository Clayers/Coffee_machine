package com.example.coffee_machine.repository;

import com.example.coffee_machine.entity.HistoryCoffeeMachineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface HistoryCoffeeMachineRepository extends CrudRepository<HistoryCoffeeMachineEntity,Long> {

    @Query(value = "select hcme " +
            "from HistoryCoffeeMachineEntity hcme " +
            "order by hcme.dateUse DESC nulls last")
    HistoryCoffeeMachineEntity getLastHistoryCoffeeMachineEntity();
    @Query(value = "select hcme " +
            "from HistoryCoffeeMachineEntity hcme ")
    HistoryCoffeeMachineEntity checkHistoryCoffeeMachineEntity();


}
