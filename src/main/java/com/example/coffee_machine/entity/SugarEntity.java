package com.example.coffee_machine.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "public", name ="sugar")
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class SugarEntity {
    @Id
    Long id;

    String description;

    int numberServing;

}
