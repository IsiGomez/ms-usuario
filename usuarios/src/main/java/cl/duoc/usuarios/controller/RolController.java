package cl.duoc.usuarios.controller;

import cl.duoc.usuarios.dto.response.RolResponseDto;
import cl.duoc.usuarios.service.RolService;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RolController {

    private final RolService rolService;

    @Operation(summary = "Obtener todos los roles disponibles",
               tags = {"Módulo de Roles → 1. Consultas de roles"})
    @GetMapping
    public ResponseEntity<List<RolResponseDto>> getAll() {
        return ResponseEntity.ok(rolService.getAll());
    }

    @Operation(summary = "Obtener rol por ID",
               tags = {"Módulo de Roles → 1. Consultas de roles"})
    @GetMapping("/{id}")
    public ResponseEntity<RolResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(rolService.getById(id));
    }

}
