package cl.duoc.usuarios.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter             @Setter
@AllArgsConstructor @NoArgsConstructor
public class LoginAllResponseDto {

    private Long id;
    private String username;
    private PersonResponseDto person;
    private RolResponseDto rol;

}
