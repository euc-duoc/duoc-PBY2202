package duoc.inf.pby2202.ejemplo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Entidad Vehículo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador del vehículo", example = "1")
    private int id;
    @Schema(description = "Capacidad (asientos) del vehículo", example = "5")
    private int capacidad;
    private int kilometraje;
    private int anio;
    private String modelo;
}
