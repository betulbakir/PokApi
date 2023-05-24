package com.example.pokeApi.controller;

import com.example.pokeApi.model.Pokemons;
import com.example.pokeApi.service.PokemonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/pokemons")
public class PokemonsController {

    private final PokemonsService pokemonsService;

    @Autowired
    public PokemonsController(PokemonsService pokemonsService) {
        this.pokemonsService = pokemonsService;
    }

    @GetMapping("/heaviest")
    public List<Pokemons> getHeaviestPokemons(){
        return pokemonsService.getHeaviestPokemons();
    }

    @GetMapping("/highest")
    public List<Pokemons> getHighestPokemons(){
        return pokemonsService.getHighestPokemons();
    }

    @GetMapping("/base_experience")
    public List<Pokemons> getBaseExperiencePokemons(){
        return pokemonsService.getBaseExperiencePokemons();
    }

}
