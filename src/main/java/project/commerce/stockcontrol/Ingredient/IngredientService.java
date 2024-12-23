package project.commerce.stockcontrol.Ingredient;

import project.commerce.stockcontrol.Product.ProductService;
import project.commerce.stockcontrol.dto.OrderItemDTO;
import project.commerce.stockcontrol.entity.Model.Product;
import project.commerce.stockcontrol.entity.Model.Ingredient;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IngredientService {

    IngredientRepository ingredientRepository;
    ProductService productService;

    IngredientService(IngredientRepository ingredientRepository, ProductService productService) {
        this.ingredientRepository = ingredientRepository;
        this.productService = productService;
    }

    public boolean hasEnoughIngredients(List<OrderItemDTO> productsDTO) {
        List<Long> ids = productsDTO.stream().map(OrderItemDTO::ProductId).toList();
        List<Product> products = productService.getProductsByIdIn(ids);

        var totalPerIngredient = getTotalPerIngredient(products);
        var availableIngredientsIds = totalPerIngredient.keySet().stream().toList();
        var availableIngredients =  ingredientRepository.findByIdIn(availableIngredientsIds);

        var test = availableIngredients.stream().map(ingredient -> {
           if(ingredient.getQuantityInStock() > totalPerIngredient.get(ingredient.getId())) {
               return false;
           }
            return null;
        }).toList();

        return true;
    }

    private Map<Long, Double> getTotalPerIngredient(List<Product> products) {
        return products.stream().flatMap(product -> product.getIngredients().stream())
            .collect(Collectors.groupingBy(
                    Ingredient::getId,
                    Collectors.summingDouble(Ingredient::getQuantityInStock)
            ));
    }
}
