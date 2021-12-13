package com.techelevator.dao;

import com.techelevator.model.Comic;
import com.techelevator.model.Superhero;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcSuperheroDao implements SuperheroDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcSuperheroDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public List<Superhero> listAllSuperheroes() {
        List<Superhero> superheroList = new ArrayList<>();
        String sql = "SELECT * FROM superheroes";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()) {
            superheroList.add(mapRowToSuperhero(result));
        }
        return superheroList;
    }

    @Override
    public List<Superhero> listAllSuperheroesInComic(int comicId) {
        List<Superhero> superheroList = new ArrayList<>();
        String sql = "SELECT * FROM superheroes s " +
                "JOIN comic_superheroes cs ON s.superhero_id = cs.superhero_id " +
                "WHERE cs.comic_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, comicId);
        while(result.next()) {
            superheroList.add(mapRowToSuperhero(result));
        }
        return superheroList;
    }

    @Override
    public Superhero getSuperheroByName(String name) {
        Superhero superhero = new Superhero();
        String sql = "SELECT * FROM superheroes WHERE superhero = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, name);
        if(result.next()) {
            return mapRowToSuperhero(result);
        } else {
            return superhero;
        }
    }

    @Override
    public Superhero createSuperhero(Superhero superhero) {
        String heroName = superhero.getSuperheroName();
        String sql = "INSERT INTO superheroes (superhero) VALUES (?) RETURNING superhero_id";
        int superheroId = jdbcTemplate.queryForObject(sql, Integer.class, heroName);
        superhero.setSuperheroId(superheroId);
        return superhero;
    }


    private Superhero mapRowToSuperhero(SqlRowSet rs) {
        Superhero superhero = new Superhero();
        superhero.setSuperheroId(rs.getInt("superhero_id"));
        superhero.setSuperheroName(rs.getString("superhero"));
        return superhero;
    }
}
