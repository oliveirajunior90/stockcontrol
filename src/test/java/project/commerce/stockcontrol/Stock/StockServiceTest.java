package project.commerce.stockcontrol.Stock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import project.commerce.stockcontrol.Product.ProductService;
import project.commerce.stockcontrol.dto.OrderItemDTO;
import project.commerce.stockcontrol.entity.Model.Ingredient;
import project.commerce.stockcontrol.entity.Model.Product;
import project.commerce.stockcontrol.entity.Model.ProductIngredient;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StockServiceTest {

    @Mock
    ProductService productService;

    @InjectMocks
    StockService stockService;

    @Mock
    StockRepository stockRepository;

    @BeforeEach
    void setUp() {
        stockService = new StockService(stockRepository, productService);
    }


    @Test
    public void testUpdateStockItems_AllIngredientsInStock() {
        // Setup
        Optional<Ingredient> ingredient1 = Optional.of(new Ingredient(1L, "ingredient 1", 5000.00, "ml", "ingredient-1"));
        Optional<Ingredient> ingredient2 = Optional.of(new Ingredient(2L, "ingredient 2", 9000.00, "ml", "ingredient-2"));

        ProductIngredient productIngredient1 = new ProductIngredient(ingredient1.get().getId(), 100.00);
        ProductIngredient productIngredient2 = new ProductIngredient(ingredient1.get().getId(), 200.00);

        Set<ProductIngredient> ingredients = new HashSet<>();
        ingredients.add(productIngredient1);
        ingredients.add(productIngredient2);

        Optional<Product> product1 = Optional.of(new Product(1L, "Test Product", "Test Description", 10.0, "test-product", ingredients));
        Optional<Product> product2 = Optional.of(new Product(2L, "Test Product 2", "Test Description 2", 20.0, "test-product-2", ingredients));

        OrderItemDTO orderItem1 = new OrderItemDTO(1L, 1L, 3);
        OrderItemDTO orderItem2 = new OrderItemDTO(1L, 2L, 3);

        doReturn(product1).when(productService).findById(1L);
        doReturn(product2).when(productService).findById(2L);
        doReturn(ingredient1).when(stockRepository).findById(1L);
        doReturn(ingredient2).when(stockRepository).findById(2L);

        stockService.updateStockItems(List.of(orderItem1, orderItem2));

        ArgumentCaptor<Ingredient> ingredientCaptor = ArgumentCaptor.forClass(Ingredient.class);
        verify(stockRepository, times(4)).save(ingredientCaptor.capture());
    }

}