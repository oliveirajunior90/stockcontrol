package project.commerce.stockcontrol.Ingredient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import project.commerce.stockcontrol.Product.ProductRepository;
import project.commerce.stockcontrol.Product.ProductService;
import project.commerce.stockcontrol.dto.OrderItemDTO;
import project.commerce.stockcontrol.entity.Model.Ingredient;
import project.commerce.stockcontrol.entity.Model.Product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IngredientServiceTest {

    @Mock
    ProductService productService;

    @InjectMocks
    IngredientService ingredientService;

    @Mock
    ProductRepository productRepository;

    @Mock
    IngredientRepository ingredientRepository;

    @BeforeEach
    void setUp() {
        ingredientService = new IngredientService(ingredientRepository, productService);
    }

    @Test
    public void testHasEnoughIngredients() {

        Ingredient ingredient1 = new Ingredient(
                1L,
                "Test Ingredient",
                500.0,
                "ml",
                "test-ingredient"
        );

        Ingredient ingredient2 = new Ingredient(
                2L,
                "Test Ingredient 2",
                900.0,
                "l",
                "test-ingredient-2"
                );

        Set<Ingredient> ingredients = new HashSet<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);


        Product product1 = new Product(
                1L,
                "Test Product",
                "Test Description",
                10.0,
                "test-product",
                ingredients
        );

        Product product2 = new Product(
                2L,
                "Test Product 2",
                "Test Description 2",
                20.0,
                "test-product-2",
                ingredients
        );


        OrderItemDTO orderItem1 = new OrderItemDTO(
                1L,
                3
        );

        OrderItemDTO orderItem2 = new OrderItemDTO(
                2L,
                3
        );

        doReturn(List.of(product1, product2)).when(productService).getProductsByIdIn(List.of(1L, 2L));
        doReturn(List.of(ingredient1, ingredient2)).when(ingredientRepository).findByIdIn(List.of(1L, 2L));
        boolean result = ingredientService.hasEnoughIngredients(List.of(orderItem1, orderItem2));

        assertTrue(result);
    }

}
