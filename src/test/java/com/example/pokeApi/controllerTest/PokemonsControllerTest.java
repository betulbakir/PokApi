package com.example.pokeApi.controllerTest;

import com.example.pokeApi.controller.PokemonsController;
import com.example.pokeApi.model.Pokemons;
import com.example.pokeApi.service.PokemonsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PokemonsControllerTest {

    private PokemonsController pokemonsController;

    @Mock
    private PokemonsService pokemonsService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        pokemonsController = new PokemonsController(pokemonsService);
    }

    @Test
    public void testGetHeaviestPokemons() {

        List<Pokemons> expectedPokemons = Arrays.asList(
                new Pokemons("Pikachu", 85, 54, 43),
                new Pokemons("Charizard", 90, 17, 34),
                new Pokemons("Snorlax", 460, 21, 32),
                new Pokemons("Gyarados", 235, 65, 62),
                new Pokemons("Dragonite", 210, 22, 65)
        );

        when(pokemonsService.getHeaviestPokemons()).thenReturn(expectedPokemons);

        List<Pokemons> actualPokemons = pokemonsController.getHeaviestPokemons();

        assertEquals(expectedPokemons, actualPokemons);
    }

    @Test
    public void testGetHighestPokemons() {
        List<Pokemons> expectedPokemons = Arrays.asList(
                new Pokemons("Alakazam", 48, 15, 74),
                new Pokemons("Dragonite", 210, 22, 76),
                new Pokemons("Charizard", 90, 17, 26),
                new Pokemons("Gyarados", 235, 65, 43),
                new Pokemons("Machamp", 130, 16, 23)
        );

        when(pokemonsService.getHighestPokemons()).thenReturn(expectedPokemons);

        List<Pokemons> actualPokemons = pokemonsController.getHighestPokemons();

        assertEquals(expectedPokemons, actualPokemons);
    }

    @Test
    public void testGetBaseExperiencePokemons() {
        List<Pokemons> expectedPokemons = Arrays.asList(
                new Pokemons("Mewtwo", 306, 2, 54),
                new Pokemons("Dragonite", 210, 2, 54),
                new Pokemons("Charizard", 90, 1, 65),
                new Pokemons("Snorlax", 154, 2, 23),
                new Pokemons("Alakazam", 186, 1, 23)
        );

        when(pokemonsService.getBaseExperiencePokemons()).thenReturn(expectedPokemons);

        List<Pokemons> actualPokemons = pokemonsController.getBaseExperiencePokemons();

        assertEquals(expectedPokemons, actualPokemons);
    }
}
