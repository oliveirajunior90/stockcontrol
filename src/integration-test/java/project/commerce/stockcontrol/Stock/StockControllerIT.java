package project.commerce.stockcontrol.Stock;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import project.commerce.stockcontrol.BaseSpec;

import project.commerce.stockcontrol.application.service.ProductService;
import project.commerce.stockcontrol.application.dto.OrderItemDTO;
import project.commerce.stockcontrol.application.service.StockService;
import project.commerce.stockcontrol.domain.entity.Ingredient;
import project.commerce.stockcontrol.domain.entity.Product;
import project.commerce.stockcontrol.domain.entity.ProductIngredient;
import project.commerce.stockcontrol.domain.repository.StockRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class StockControllerIT extends BaseSpec {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockService stockService;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:16-alpine"
    );
    @Autowired
    private ProductService productService;

    @DynamicPropertySource
    static void registerPgProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @BeforeEach
    void setUp() {
        stockRepository.deleteAll();
    }


    @Test
    public void createIngredient() {

        // Create a new ingredient
        Ingredient ingredient = new Ingredient(1L, "ingredient 1", 5000.00, "ml", "ingredient-1");

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // Create request
        HttpEntity<Ingredient> request = new HttpEntity<>(ingredient, headers);

        // Perform the request
        String url = "http://localhost:" + port + "/api/v1/stock/create";
        ResponseEntity<Ingredient> response = restTemplate.exchange(url, HttpMethod.POST, request, Ingredient.class);

        // Verify the results

        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals("ingredient 1", response.getBody().getName());
    }

    @Test
    public void testUpdateStockItems() {

        // Setup initial data
        Ingredient ingredient1 = new Ingredient(1L, "ingredient 1", 9000.00, "ml", "ingredient-1");
        Ingredient ingredient2 = new Ingredient(2L, "ingredient 2", 7000.00, "ml", "ingredient-2");
        stockRepository.save(ingredient1);
        stockRepository.save(ingredient2);

        Set<ProductIngredient> productIngredients = new HashSet<>();
        productIngredients.add(new ProductIngredient(1L, 300));
        productIngredients.add(new ProductIngredient(2L , 200));


        Product product = new Product(null, "Product 1", "Description 1", 100.00, "product-1", productIngredients);
        productService.save(product);

        // Create order items to update stock
        OrderItemDTO orderItem1 = new OrderItemDTO(1L, 1L,3);
        OrderItemDTO orderItem2 = new OrderItemDTO(1L, 1L, 1);
        List<OrderItemDTO> orderItems = List.of(orderItem1, orderItem2);

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // Create request
        HttpEntity<List<OrderItemDTO>> request = new HttpEntity<>(orderItems, headers);

        // Perform the request
        String url = "http://localhost:" + port + "/api/v1/stock/update-stock";
        ResponseEntity<Boolean> response = restTemplate.exchange(url, HttpMethod.POST, request, Boolean.class);

        // Verify the results
        assertEquals(200, response.getStatusCode().value());
        assertEquals(true, response.getBody());

        Ingredient updatedIngredient1 = stockRepository.findById(1L).orElseThrow();
        Ingredient updatedIngredient2 = stockRepository.findById(2L).orElseThrow();

        assertEquals(7800.00, updatedIngredient1.getQuantityInStock());
        assertEquals(6200.00, updatedIngredient2.getQuantityInStock());
    }
}