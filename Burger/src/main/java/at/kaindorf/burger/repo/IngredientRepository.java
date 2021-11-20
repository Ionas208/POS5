package at.kaindorf.burger.repo;

import at.kaindorf.burger.pojos.Burger;
import at.kaindorf.burger.pojos.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 19.11.2021
    Time: 12:18
*/
public interface IngredientRepository extends JpaRepository<Ingredient, String> {
}
