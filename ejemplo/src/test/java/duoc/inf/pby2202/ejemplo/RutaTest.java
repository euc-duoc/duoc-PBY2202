package duoc.inf.pby2202.ejemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import duoc.inf.pby2202.ejemplo.model.Ruta;
import duoc.inf.pby2202.ejemplo.model.Vehiculo;

public class RutaTest {

    @Test
    void probarVehiculoCorrecto() {
        Vehiculo vh = new Vehiculo();
        vh.setAnio(2005);
        vh.setCapacidad(4);
        vh.setId(3);
        vh.setKilometraje(50000);
        vh.setModelo("Nissan");

        Ruta ruta = new Ruta();
        ruta.setId(1);
        ruta.setVehiculo(vh);

        assertNotNull(ruta.getVehiculo());
        assertEquals(ruta.getVehiculo().getId(), 3);
        assertEquals(ruta.getVehiculo().getCapacidad(), 4);
    }
}
