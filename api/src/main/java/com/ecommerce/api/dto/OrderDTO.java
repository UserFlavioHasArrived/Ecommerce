package com.ecommerce.api.dto;

import com.ecommerce.api.entities.OrderStatus;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    @NotNull(message = "A data do pedido é obrigatória.")
    @PastOrPresent(message = "A data do pedido não pode ser no futuro.")
    private LocalDateTime moment;
    @NotBlank(message = "O status do pedido é obrigatório.")
    @Pattern(regexp = "WAITING_PAYMENT|PAID|SHIPPED|DELIVERED|CANCELLED", message = "O status deve ser CREATED, PAID, SHIPPED ou CANCELLED.")
    private OrderStatus status;
    private UserDTO user;
    private PaymentDTO payment;
    @NotEmpty(message = "É obrigatório selecionar pelo menos um item")
    private List<OrderItemDTO> orderItems;
}
