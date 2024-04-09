package org.grupo_e.rungroup.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class RegistrationDto {
    private long id;
    @NotEmpty(message = "El usuario no puede estar vacío")
    private String username;
    @NotEmpty(message = "El email no puede estar vacío")
    private String email;
    @NotEmpty(message = "La contraseña no puede estar vacía")
    private String password;
}
