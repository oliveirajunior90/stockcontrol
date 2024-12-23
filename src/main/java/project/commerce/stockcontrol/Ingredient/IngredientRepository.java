package project.commerce.stockcontrol.Ingredient;

import org.springframework.data.jpa.repository.JpaRepository;
import project.commerce.stockcontrol.entity.Model.Ingredient;

import java.util.List;
import java.util.Set;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findByIdIn(List<Long> ids);
}
