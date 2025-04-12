package com.example.Papeleria.Controller;

import com.example.Papeleria.Model.Venta;
import com.example.Papeleria.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> listar() {
        return ventaService.listar();
    }

    @PostMapping
    public Venta guardar(@RequestBody Venta venta) {
        return ventaService.guardar(venta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        ventaService.eliminar(id);
    }

    @GetMapping("/{id}")
    public Venta buscar(@PathVariable Integer id) {
        return ventaService.buscarPorId(id);
    }

    @GetMapping("/empleado/{idEmpleado}")
    public List<Object[]> obtenerVentasPorEmpleado(@PathVariable Integer idEmpleado) {
        return ventaService.obtenerVentasPorEmpleado(idEmpleado);
    }


    @GetMapping("/empleado/{idEmpleado}/fecha/{fecha}")
    public List<Object[]> obtenerVentasPorEmpleadoYFecha(@PathVariable Integer idEmpleado,
                                                         @PathVariable String fecha) {
        return ventaService.obtenerVentasPorEmpleadoYFecha(idEmpleado, LocalDate.parse(fecha));
    }
}