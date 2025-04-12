package com.example.Papeleria.Repository;

import com.example.Papeleria.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

//consulta para ver las ventas de un empleado con sus clientes
    @Query("SELECT v.idVenta, v.fecha, c.nombre " +
            "FROM Venta v JOIN v.cliente c " +
            "WHERE v.empleado.idEmpleado = :idEmpleado")
    List<Object[]> findVentasByEmpleado(@Param("idEmpleado") Integer idEmpleado);

//Consulta para ver las	ventas de un empleado por fecha
    @Query("SELECT v.idVenta, v.fecha, c.nombre " +
            "FROM Venta v JOIN v.cliente c " +
            "WHERE v.empleado.idEmpleado = :idEmpleado AND v.fecha = :fecha")
    List<Object[]> findVentasByEmpleadoAndFecha(@Param("idEmpleado") Integer idEmpleado,
                                                @Param("fecha") LocalDate fecha);
}

