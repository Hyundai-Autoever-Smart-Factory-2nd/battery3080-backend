package com.example.demo.model;

import java.util.List;

import lombok.Getter;

@Getter
public class Equipment {
    private Long equipmentId;
    private String name;

    private List<Model> models;
}