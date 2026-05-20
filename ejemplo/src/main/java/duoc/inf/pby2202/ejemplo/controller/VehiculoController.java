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



@RestController
@RequestMapping("/api")
public class VehiculoController {
    private VehiculoService service;

    public VehiculoController(VehiculoService service) {
        this.service = service;
    }

    @GetMapping("/vehiculos")
    public ResponseEntity<List<Vehiculo>> obtenerVehiculos() {
        List<Vehiculo> vehiculos = service.obtenerVehiculos();
        
        if (vehiculos.isEmpty())
            return ResponseEntity.noContent().build();
        
        return ResponseEntity.ok(vehiculos);
    }

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
