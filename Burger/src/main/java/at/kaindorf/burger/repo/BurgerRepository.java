package at.kaindorf.burger.repo;

import at.kaindorf.burger.pojos.Burger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 19.11.2021
    Time: 12:18
*/
public interface BurgerRepository extends JpaRepository<Burger, Long> {

    @Query("SELECT b FROM Burger b WHERE b.name = ?1 ORDER BY b.id")
    List<Burger> findByNameOrderById(String name);

}
