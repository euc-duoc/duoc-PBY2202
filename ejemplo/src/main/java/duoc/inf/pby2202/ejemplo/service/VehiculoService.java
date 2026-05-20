package duoc.inf.pby2202.ejemplo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import duoc.inf.pby2202.ejemplo.model.Vehiculo;
import duoc.inf.pby2202.ejemplo.repository.VehiculoRepository;

@Service
public class VehiculoService {
    private VehiculoRepository repo;

    public VehiculoService(VehiculoRepository repo) {
        this.repo = repo;
    }

    public List<Vehiculo> obtenerVehiculos() {
        return repo.findAll();
    }

    public Vehiculo crearVehiculo(Vehiculo data) {
        return repo.save(data);
    }
}
