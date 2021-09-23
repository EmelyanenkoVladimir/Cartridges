package com.example.springbootsbyt.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cartrs")
public class Cartrs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCartrs;

    @Column(name = "chip")
    private String chip;

    @Column(name = "type_cartr")
    private String typeCartr;


}
