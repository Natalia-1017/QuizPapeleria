package com.example.Papeleria.Controller;

import com.example.Papeleria.Model.Empleado;
import com.example.Papeleria.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<Empleado> listar() {
        return empleadoService.listar();
    }

    @PostMapping
    public Empleado guardar(@RequestBody Empleado empleado) {
        return empleadoService.guardar(empleado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        empleadoService.eliminar(id);
    }

    @GetMapping("/{id}")
    public Empleado buscar(@PathVariable Integer id) {
        return empleadoService.buscarPorId(id);
    }
}
