package com.example.pokeApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pokemons {
    private String name;
    private int weight;
    private int height;
    private int base_experience;
    public Pokemons() {
    }

    public Pokemons(String name, int weight, int height, int base_experience) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.base_experience = base_experience;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBaseExperience() {
        return base_experience;
    }
    @JsonProperty("base_experience")
    public void setBaseExperience(int baseExperience) {
        this.base_experience = baseExperience;
    }
}
