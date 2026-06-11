package com.minimarket;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.minimarket.entity.Carrito;
import com.minimarket.entity.Producto;

public class CarritoTest {

    @Test
    void probarCarrito() {
        Carrito carr = new Carrito();

        Producto p1 = new Producto();
        p1.setNombre("milo");
        p1.setStock(10);
        p1.setPrecio(1000.0);

        carr.setProducto(p1);
        carr.setCantidad(8);

        assertTrue(() -> p1.getStock() >= carr.getCantidad());
    }
}
