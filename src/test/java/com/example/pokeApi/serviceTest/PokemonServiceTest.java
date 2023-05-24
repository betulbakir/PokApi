package com.example.pokeApi.serviceTest;
import com.example.pokeApi.model.Pokemons;
import com.example.pokeApi.service.PokemonsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;
import java.util.Arrays;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PokemonServiceTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    PokemonsService pokemonsService = new PokemonsService();
    PokemonsService mockPokemonService = Mockito.spy(pokemonsService);

    @BeforeEach
    public void SetUp(){


        List<Pokemons> pokemons = Arrays.asList(
                new Pokemons("Pikachu", 15, 14, 43),
                new Pokemons("Charizard", 12, 17, 23),
                new Pokemons("Snorlax", 18, 21, 13),
                new Pokemons("Gyarados", 23, 19, 53),
                new Pokemons("Charmander", 20, 39, 32),
                new Pokemons("Dragonite", 21, 22, 65)
        );

        Mockito.doReturn(pokemons).when(mockPokemonService).getAllPokemons();
    }


    @Test
    public void testGetHeaviestPokemons() {

        Assertions.assertEquals(5, mockPokemonService.getHeaviestPokemons().size());
        Assertions.assertEquals("Gyarados", mockPokemonService.getHeaviestPokemons().get(0).getName());
        Assertions.assertEquals("Pikachu", mockPokemonService.getHeaviestPokemons().get(4).getName());

    }

    @Test
    public void testGetHighestPokemons() {

        Assertions.assertEquals(5, mockPokemonService.getHighestPokemons().size());
        Assertions.assertEquals("Dragonite", mockPokemonService.getHighestPokemons().get(1).getName());
        Assertions.assertEquals("Gyarados", mockPokemonService.getHighestPokemons().get(3).getName());

    }

    @Test
    public void testGetBaseExperiencePokemons() {

        Assertions.assertEquals(5, mockPokemonService.getBaseExperiencePokemons().size());
        Assertions.assertEquals("Dragonite", mockPokemonService.getBaseExperiencePokemons().get(0).getName());
        Assertions.assertEquals("Charizard", mockPokemonService.getBaseExperiencePokemons().get(4).getName());

    }
}