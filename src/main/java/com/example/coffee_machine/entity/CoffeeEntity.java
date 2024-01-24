package com.example.coffee_machine.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(schema = "public", name ="coffee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Типы Кофе")
public class CoffeeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long coffeeId;

    String nameCoffee;

    Integer quantityCoffee;

    Boolean milk;

    Double water;

    Double coffee;

    Double pollution;

}
