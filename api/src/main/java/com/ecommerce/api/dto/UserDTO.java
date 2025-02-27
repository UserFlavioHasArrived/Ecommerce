package com.ecommerce.api.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

    @Data
    public class UserDTO {
        private Long id;

        @NotBlank(message = "O nome é obrigatório.") // Valida que o campo não é nulo nem vazio.
        @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
        private String name;

        @NotBlank(message = "O email é obrigatório.")
        @Email(message = "O email deve ser válido.") // Valida o formato do email.
        private String email;

        @NotBlank(message = "A senha é obrigatória.")
        @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres.")
        private String password;

        @Pattern(regexp = "\\+?[0-9\\-\\(\\)\\s]{9,15}", // Regex para validar telefones com formato internacional ou nacional.
                message = "O telefone deve ter um formato válido.")
        private String phone;

        @Past(message = "A data de nascimento deve ser no passado.") // Apenas datas passadas.
        private String birthDate;

        @NotBlank(message = "O papel do usuário é obrigatório.")
        @Pattern(regexp = "ADMIN|USER|MANAGER", message = "O papel deve ser ADMIN, USER ou MANAGER.")
        private String roles;
    }

