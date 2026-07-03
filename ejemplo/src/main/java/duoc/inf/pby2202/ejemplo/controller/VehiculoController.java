package duoc.inf.pby2202.ejemplo.controller;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import duoc.inf.pby2202.ejemplo.model.Vehiculo;
import duoc.inf.pby2202.ejemplo.service.VehiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

// Guía de anotaciones para Swagger
// https://medium.com/dev-spring/mastering-swagger-annotations-for-sring-boot-3c11be67562f

@RestController
@RequestMapping("/api")
public class VehiculoController {
    private VehiculoService service;

    public VehiculoController(VehiculoService service) {
        this.service = service;
    }

    @Operation(
        summary = "Obtiene la lista de vehículos.",
        description = "Obtiene la lista completa de vehículos que está almacenada en la BD.",
        tags = {"Vehiculos"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Lista generada correctamente.",
            content = @Content(
                mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = Vehiculo.class))
            )
        ),
        @ApiResponse(responseCode = "401", description = "No hay acceso a la API.")
    })
    @GetMapping("/vehiculos")
    public ResponseEntity<List<Vehiculo>> obtenerVehiculos() {
        List<Vehiculo> vehiculos = service.obtenerVehiculos();
        
        if (vehiculos.isEmpty())
            return ResponseEntity.noContent().build();
        
        return ResponseEntity.ok(vehiculos);
    }
    
    @Operation(summary = "Crea un nuevo vehículo en el sistema.")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
        description = "Datos del vehículo que se va a crear.",
        required = true,
        content = @Content(
            schema = @Schema(implementation = Vehiculo.class)
        )
    )
    @PostMapping("/vehiculos")
    public ResponseEntity<?> guardarVehiculo(@RequestBody Vehiculo datos) {
        try {
            Vehiculo res = service.crearVehiculo(datos);
            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        } 
        catch (DataAccessException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error: " + ex.getMostSpecificCause().getMessage());
        }
    }    
}
