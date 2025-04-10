package com.example.Papeleria.Repository;

import com.example.Papeleria.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // Clientes con su detalle de venta
    @Query(value = "SELECT c.*, dv.* FROM cliente c " +
            "JOIN venta v ON v.id_cliente = c.id_cliente " +
            "JOIN detalle_venta dv ON dv.id_venta = v.id_venta", nativeQuery = true)
    List<Object[]> findClientesWithDetalleVenta();
}
