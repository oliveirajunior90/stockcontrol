package project.commerce.stockcontrol.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.commerce.stockcontrol.domain.entity.Ingredient;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Ingredient, Long> {

    Optional<Ingredient> findById(Long id);

    Ingredient save(Ingredient ingredient);
}
