package cl.duoc.usuarios.controller;

import cl.duoc.usuarios.dto.request.LoginRequestDto;
import cl.duoc.usuarios.dto.response.LoginAllResponseDto;
import cl.duoc.usuarios.dto.response.LoginResponseDto;
import cl.duoc.usuarios.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/logins")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @Operation(summary = "Obtener todas las cuentas",
               tags = {"Módulo de Cuentas → 1. Consultas de Cuentas"})
    @GetMapping
    public ResponseEntity<List<LoginAllResponseDto>> getAll() {
        return ResponseEntity.ok(loginService.getAll());
    }

    @Operation(summary = "Obtener cuenta por ID",
               tags = {"Módulo de Cuentas → 1. Consultas de Cuentas"})
    @GetMapping("/{id}")
    public ResponseEntity<LoginAllResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(loginService.getByIdInfo(id));
    }

    @Operation(summary = "Obtener el rol de una cuenta por su ID",
               tags = {"Módulo de Cuentas → 1. Consultas de Cuentas"})
    @GetMapping("/{id}/rol")
    public ResponseEntity<LoginResponseDto> getRolById(@PathVariable Long id){
        return ResponseEntity.ok(loginService.getById(id));
    }

    @Operation(summary = "Crear nueva cuenta",
               tags = {"Módulo de Cuentas → 2. Acciones de Cuentas"})
    @PostMapping
    public ResponseEntity<LoginAllResponseDto> create(@Valid @RequestBody LoginRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loginService.create(dto));
    }

    @Operation(summary = "Actualizar cuenta existente",
               tags = {"Módulo de Cuentas → 2. Acciones de Cuentas"})
    @PutMapping("/{id}")
    public ResponseEntity<LoginAllResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody LoginRequestDto dto
    ) {
        return ResponseEntity.ok(loginService.update(id, dto));
    }

    @Operation(summary = "Eliminar cuenta por ID",
               tags = {"Módulo de Cuentas → 2. Acciones de Cuentas"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!loginService.delete(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
