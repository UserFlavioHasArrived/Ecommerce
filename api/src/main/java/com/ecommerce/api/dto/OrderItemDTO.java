// OrderItemDTO.java
package com.ecommerce.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderItemDTO {
    private Long orderId; // ID do pedido (extraído de OrderItemPK)
    private Long productId; // ID do produto (extraído de OrderItemPK)
    @NotNull(message = "A quantidade é obrigatória.")
    @Positive(message = "A quantidade deve ser positiva.")
    private Integer quantity;
    @NotNull(message = "O preço é obrigatório.")
    @Positive(message = "O preço deve ser positivo.")
    private Double price;
}