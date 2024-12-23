package project.commerce.stockcontrol.dto;

public record OrderItemDTO(
        Long ProductId,
        int quantity
) {
}
