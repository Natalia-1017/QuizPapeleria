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
    private VentaService service;

    @GetMapping
    public List<Venta> listar() {
        return service.listar();
    }

    @PostMapping
    public Venta guardar(@RequestBody Venta venta) {
        return service.guardar(venta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }

    @GetMapping("/{id}")
    public Venta buscar(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    // Ventas por empleado
    @GetMapping("/empleado/{idEmpleado}")
    public List<Venta> listarPorEmpleado(@PathVariable Integer idEmpleado) {
        return service.listarPorEmpleado(idEmpleado);
    }

    // Ventas por empleado en una fecha específica
    @GetMapping("/empleado/{idEmpleado}/fecha")
    public List<Venta> listarPorEmpleadoYFecha(@PathVariable Integer idEmpleado, @RequestParam String fecha) {
        LocalDate fechaParsed = LocalDate.parse(fecha);
        return service.listarPorEmpleadoYFecha(idEmpleado, fechaParsed);
    }
}
