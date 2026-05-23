package cl.duoc.usuarios.controller;

import cl.duoc.usuarios.dto.request.PersonRequestDto;
import cl.duoc.usuarios.dto.response.PersonResponseDto;
import cl.duoc.usuarios.service.PersonService;
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
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @Operation(summary = "Obtener todas las personas",
               tags = {"Módulo de Personas → 1. Consultas de Personas"})
    @GetMapping
    public ResponseEntity<List<PersonResponseDto>> getAll() {
        return ResponseEntity.ok(personService.getAll());
    }

    @Operation(summary = "Obtener persona por ID",
               tags = {"Módulo de Personas → 1. Consultas de Personas"})
    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getById(id));
    }

    @Operation(summary = "Crear nueva informacion de persona",
               tags = {"Módulo de Personas → 2. Acciones de Personas"})
    @PostMapping
    public ResponseEntity<PersonResponseDto> create(@Valid @RequestBody PersonRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.create(dto));
    }

    @Operation(summary = "Actualizar categoria existente",
               tags = {"Módulo de Personas → 2. Acciones de Personas"})
    @PutMapping("/{id}")
    public ResponseEntity<PersonResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody PersonRequestDto dto
    ) {
        return ResponseEntity.ok(personService.update(id, dto));
    }

    @Operation(summary = "Eliminar información de Persona por ID",
               tags = {"Módulo de Personas → 2. Acciones de Personas"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!personService.delete(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
