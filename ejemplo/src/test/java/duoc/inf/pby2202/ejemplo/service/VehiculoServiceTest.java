package duoc.inf.pby2202.ejemplo.service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import duoc.inf.pby2202.ejemplo.model.Vehiculo;
import duoc.inf.pby2202.ejemplo.repository.VehiculoRepository;

public class VehiculoServiceTest {
    @Autowired
    private VehiculoRepository repo;

    @Test
    void pruebaVehiculos() {
        VehiculoService vs = new VehiculoService(repo);
        List<Vehiculo> vehiculos = vs.obtenerVehiculos();
        assertEquals(vehiculos.size(), 2);
    }
}
