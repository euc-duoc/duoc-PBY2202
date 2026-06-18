package duoc.inf.pby2202.ejemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import duoc.inf.pby2202.ejemplo.model.Vehiculo;
import duoc.inf.pby2202.ejemplo.repository.VehiculoRepository;
import duoc.inf.pby2202.ejemplo.service.VehiculoService;

@ExtendWith(MockitoExtension.class)
public class VehiculoServiceTest {
    private Vehiculo[] veh = {
        new Vehiculo(1, 4, 100000, 2015, "Nissan"),
        new Vehiculo(2, 5, 90000, 2000, "Subarú")
    };

    @Mock
    private VehiculoRepository repo;
    @InjectMocks
    private VehiculoService service;

    @Test
    void probarServicio() {        
        Mockito.when(repo.findAll()).thenReturn(java.util.Arrays.asList(veh));
        Mockito.when(repo.findById(10)).thenReturn(null);

        assertEquals(service.obtenerVehiculos().size(), 2);
        assertEquals(service.obtenerVehiculos().get(1).getAnio(), 2000);
        assertNull(service.obtenerVehiculoPorId(10));
    }
}
