package com.techelevator.dao;

import com.techelevator.model.Superhero;

import java.util.List;

public interface SuperheroDao {

    List<Superhero> listAllSuperheroes();
    List<Superhero> listAllSuperheroesInComic(int comicId);
    Superhero getSuperheroByName(String name);
    Superhero createSuperhero(Superhero superhero);
    void createComicSuperhero(int superheroId, int comicId);

}
