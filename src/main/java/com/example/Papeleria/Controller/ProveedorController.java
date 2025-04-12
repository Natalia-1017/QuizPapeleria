package com.example.Papeleria.Controller;

import com.example.Papeleria.Model.Proveedor;
import com.example.Papeleria.Service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<Proveedor> listar() {
        return proveedorService.listar();
    }

    @PostMapping
    public Proveedor guardar(@RequestBody Proveedor proveedor) {
        return proveedorService.guardar(proveedor);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        proveedorService.eliminar(id);
    }

    @GetMapping("/{id}")
    public Proveedor buscar(@PathVariable Integer id) {
        return proveedorService.buscarPorId(id);
    }
    @GetMapping("/{idProveedor}/productos")
    public List<Object[]> listarProductosPorProveedor(@PathVariable Integer idProveedor) {
        return proveedorService.listarProductosPorProveedor(idProveedor);
    }

}
