package com.example.coffee_machine.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(schema = "public", name ="history_coffee_machine")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Типы Кофе")
public class HistoryCoffeeMachineEntity {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Long id;

    String action;

    Date dateUse;

    boolean nutrition;

    @ManyToOne
    CoffeeEntity coffeeEntity;

    @ManyToOne
    SugarEntity sugarEntity;

    Double water;

    Double coffee;

    Double pollution;

    Double milk ;

}
