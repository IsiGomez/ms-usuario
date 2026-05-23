package cl.duoc.usuarios.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter             @Setter
@AllArgsConstructor @NoArgsConstructor
public class PersonResponseDto {

    private Long id;
    private String rut;
    private String name;
    private String lastName;
    private String email;
    private String phone;

}
