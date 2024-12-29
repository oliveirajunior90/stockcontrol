package project.commerce.stockcontrol.application.usecase;

import org.springframework.stereotype.Component;
import project.commerce.stockcontrol.application.dto.OrderItemDTO;
import project.commerce.stockcontrol.application.service.ProductService;
import project.commerce.stockcontrol.domain.entity.Ingredient;
import project.commerce.stockcontrol.domain.repository.StockRepository;

import java.util.List;

@Component
public class UpdateStockUseCase {
    private final ProductService productService;
    private final StockRepository stockRepository;

    public UpdateStockUseCase(ProductService productService, StockRepository stockRepository) {
        this.productService = productService;
        this.stockRepository = stockRepository;
    }

    public void execute(List<OrderItemDTO> orderItemDTO) {
        orderItemDTO.forEach(orderItem -> {

            var productDB = productService.findById(orderItem.productId());
            if(productDB.isPresent()) {
                var ingredientsProduct = productDB.get().getIngredients();

                ingredientsProduct.forEach(item -> {
                    var ingredientStock = stockRepository.findById(item.getIngredientId());
                    if(ingredientStock.isEmpty()) {
                        throw new RuntimeException(String.format("Não há o item de id: %s no estoque", item.getIngredientId()));
                    }

                    var ingredient = new Ingredient();
                    ingredient.setId(item.getIngredientId());
                    ingredient.setUpdatedAt();
                    ingredient.setQuantityInStock(ingredientStock.get().getQuantityInStock() - item.getQuantity() * orderItem.quantity());
                    stockRepository.save(ingredient);
                });
            }

        });
    }
}
