package com.example.pokeApi.service;

import com.example.pokeApi.model.PokemonListResponse;
import com.example.pokeApi.model.Pokemons;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PokemonsService {

    private final RestTemplate restTemplate;

    public PokemonsService() {
        this.restTemplate = new RestTemplate();
    }

    public List<Pokemons> getHeaviestPokemons() {
        List<Pokemons> allPokemons = getAllPokemons();

        allPokemons.sort(Comparator.comparing(Pokemons::getWeight).reversed());

        return allPokemons.subList(0, 5);
    }

    public List<Pokemons> getHighestPokemons() {
        List<Pokemons> allPokemons = getAllPokemons();

        allPokemons.sort(Comparator.comparing(Pokemons::getHeight).reversed());

        return allPokemons.subList(0, 5);
    }

    public List<Pokemons> getBaseExperiencePokemons() {
        List<Pokemons> allPokemons = getAllPokemons();

        allPokemons.sort(Comparator.comparing(Pokemons::getBaseExperience).reversed());

        return allPokemons.subList(0, 5);
    }

    public List<Pokemons> getAllPokemons() {
        int limit = 1000;
        int offset = 0;
        int totalPokemons = 0;
        List<Pokemons> allPokemons = new ArrayList<>();

        do {
            String apiUrl = "https://pokeapi.co/api/v2/pokemon?offset=" + offset + "&limit=" + limit;
            PokemonListResponse response = restTemplate.getForObject(apiUrl, PokemonListResponse.class);

            if (response != null) {
                List<PokemonListResponse.Result> pokemonResults = response.getResults();

                for (PokemonListResponse.Result result : pokemonResults) {
                    String pokemonUrl = result.getUrl();
                    Pokemons pokemon = getPokemonDetails(pokemonUrl);
                    if (pokemon != null) {
                        allPokemons.add(pokemon);
                    }
                }

                totalPokemons = response.getCount();
            }

            offset += limit;
        } while (offset < totalPokemons);

        return allPokemons;
    }

    private Pokemons getPokemonDetails(String pokemonUrl) {
        return restTemplate.getForObject(pokemonUrl, Pokemons.class);
    }
}