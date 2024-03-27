package com.example.medicamentos.controller;

import com.example.medicamentos.entity.Medicamento;
import com.example.medicamentos.service.MedicamentoService;
import com.example.medicamentos.service.MedicamentoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/medicamento")
@CrossOrigin(origins = "*")
public class MedicamentoController {

    public MedicamentoService medicamentoService;

    @Autowired
    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @GetMapping("/")
    @Operation(summary = "Obtener todos los medicamentos",
            description = "Obtiene la lista completa de todos los medicamentos disponibles en el sistema",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de medicamentos obtenida correctamente",
                            content = @Content(schema = @Schema(implementation = List.class),
                                    examples = @ExampleObject(value = "[{\"idMedicamento\":1,\"nombreMedicamento\":\"DolexForte,\"url\":\"https://dev.azure.com/\"}]")))
            })
    public ResponseEntity<List<Medicamento>> getUsers() {
        try {
            System.out.println("Se realiza petición para obtener todos los medicamentos");
            List<Medicamento> medicamentos = medicamentoService.findAllMedicamentos();
            return ResponseEntity.ok(medicamentos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/byid/{id}")
    @Operation(summary = "Obtener un medicamento por ID",
            description = "Obtiene un medicamento específico por su ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Medicamento encontrado",
                            content = @Content(schema = @Schema(implementation = Medicamento.class),
                                    examples = @ExampleObject(value = "{\"idMedicamento\":1,\"nombreMedicamento\":\"DolexForte,\"url\":\"https://dev.azure.com/"))),
                    @ApiResponse(responseCode = "404", description = "Medicamento no encontrado"),
                    @ApiResponse(responseCode = "500", description = "Error al procesar la solicitud")
            })
    public ResponseEntity<List<Medicamento>> getById(@PathVariable Long id) {
        try {
            System.out.println("Se realiza petición para obtener medicamento por id = "+id);
            List<Medicamento> medicamentos = medicamentoService.findById(id);
            if (medicamentos.isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(medicamentos);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un medicamento por ID",
            description = "Elimina un medicamento existente en el sistema por su ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Medicamento eliminado correctamente"),
                    @ApiResponse(responseCode = "404", description = "Medicamento no encontrado"),
                    @ApiResponse(responseCode = "500", description = "Error al procesar la solicitud")
            },
            parameters = @Parameter(name = "id", description = "ID del medicamento a eliminar", in = ParameterIn.PATH)
    )
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        try {
            System.out.println("Se realiza petición para eliminar medicamento id = "+id);
            boolean deleted = medicamentoService.deleteById(id);
            return ResponseEntity.ok(deleted);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/")
    @Operation(summary = "Crear un nuevo medicamento",
            description = "Crea un nuevo medicamento en el sistema",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Medicamento creado correctamente",
                            content = @Content(schema = @Schema(implementation = List.class),
                                    examples = @ExampleObject(value = "{\"idMedicamento\":1,\"nombreMedicamento\":\"DolexForte,\"url\":\"https://dev.azure.com/\"}]")))
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Medicamento.class),
                            examples = {
                                    @ExampleObject(name = "Ejemplo 1", summary = "Ejemplo Detallado",
                                            description = "Una descripción del ejemplo",
                                            value = "{\"nombreMedicamento\":\"DolexForte\",\"url\":\"https://dev.azure.com/\"}")

                            }
                    )
            )
    )
    public ResponseEntity<List<Medicamento>> createMedicamento(@RequestBody Medicamento medicamento) {
        try {
            System.out.println("Se realiza petición para crear medicamento" + medicamento);
            List<Medicamento> medicamentos = medicamentoService.createMedicamento(medicamento);
            return ResponseEntity.ok(medicamentos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un medicamento",
            description = "Actualiza un medicamento existente en el sistema",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Medicamento actualizado correctamente",
                            content = @Content(schema = @Schema(implementation = List.class),
                                    examples = @ExampleObject(value = "{\"idMedicamento\":1,\"nombreMedicamento\":\"DolexForte,\"url\":\"https://dev.azure.com/\"}]")))
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Medicamento.class),
                            examples = {
                                    @ExampleObject(name = "Ejemplo 1", summary = "Ejemplo Detallado",
                                            description = "Una descripción del ejemplo",
                                            value = "{\"nombreMedicamento\":\"DolexForte\",\"url\":\"https://dev.azure.com/\"}")

                            }
                    )
            )
    )
    public ResponseEntity<List<Medicamento>> updateMedicamento(@RequestBody Medicamento medicamento, @PathVariable Long id) {
        try {
            System.out.println("Se realiza petición para actualizar medicamento id = "+id);
            List<Medicamento> medicamentos = medicamentoService.updateMedicamento(medicamento, id);
            return ResponseEntity.ok(medicamentos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
