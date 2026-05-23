package cl.duoc.usuarios.dto.request;

import jakarta.validation.constraints.Email;
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
public class PersonRequestDto {

    @NotBlank(message = "El rut de la persona es obligatorio")
    @Size(max = 20, message = "El rut no puede superar los 20 caracteres")
    private String rut;

    @NotBlank(message = "El nombre de la persona es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    private String name;

    @NotBlank(message = "El apellido de la persona es obligatorio")
    @Size(max = 100, message = "El apellido no puede superar los 100 caracteres")
    private String lastName;

    @NotBlank(message = "El email de la persona es obligatorio")
    @Email(message = "El email debe tener un formato valido")
    @Size(max = 150, message = "El email no puede superar los 150 caracteres")
    private String email;

    @Size(max = 20, message = "El telefono no puede superar los 20 caracteres")
    private String phone;

}
