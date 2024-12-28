package project.commerce.stockcontrol.Stock;

import org.springframework.data.jpa.repository.JpaRepository;
import project.commerce.stockcontrol.entity.Model.Ingredient;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Ingredient, Long> {

    Optional<Ingredient> findById(Long id);

    Ingredient save(Ingredient ingredient);
}
