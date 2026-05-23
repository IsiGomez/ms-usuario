package cl.duoc.usuarios.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter             @Setter
@AllArgsConstructor @NoArgsConstructor
public class LoginRequestDto {

    @NotBlank(message = "El username es obligatorio")
    @Size(max = 100, message = "El username no puede superar los 100 caracteres")
    private String username;

    @NotBlank(message = "El password es obligatorio")
    @Size(min = 6, max = 120, message = "El password debe tener entre 6 y 120 caracteres")
    private String password;

    @NotNull(message = "La persona es obligatoria")
    @Positive(message = "La persona debe ser valida")
    private Long personId;

    @NotNull(message = "El rol es obligatorio")
    @Positive(message = "El rol debe ser valido")
    private Long rolId;

}
