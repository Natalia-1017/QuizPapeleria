package com.example.Papeleria.Repository;

import com.example.Papeleria.Model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {

//Consulta para listar clientes con sus detalles de venta
    @Query(value = "SELECT c.nombre, c.correo, d.cantidad, p.nombre AS producto " +
            "FROM cliente c " +
            "JOIN venta v ON c.id_cliente = v.id_cliente " +
            "JOIN detalle_venta d ON v.id_venta = d.id_venta " +
            "JOIN producto p ON d.id_producto = p.id_producto",
            nativeQuery = true)

    List<Object[]> listarClientesConDetalles();
}
