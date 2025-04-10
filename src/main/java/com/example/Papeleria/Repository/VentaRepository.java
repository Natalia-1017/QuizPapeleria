package com.example.Papeleria.Repository;


import com.example.Papeleria.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Integer> {

    // Ventas de un empleado con sus clientes
    @Query(value = "SELECT v.* FROM venta v WHERE v.id_empleado = ?1", nativeQuery = true)
    List<Venta> findVentasByEmpleado(Integer idEmpleado);

    // Ventas de un empleado por fecha
    @Query(value = "SELECT * FROM venta v WHERE v.id_empleado = ?1 AND v.fecha = ?2", nativeQuery = true)
    List<Venta> findVentasByEmpleadoAndFecha(Integer idEmpleado, LocalDate fecha);
}
