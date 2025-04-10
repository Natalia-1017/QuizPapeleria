package com.example.Papeleria.Service;

import com.example.Papeleria.Model.Venta;
import com.example.Papeleria.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository repository;

    public List<Venta> listar() {
        return repository.findAll();
    }

    public Venta guardar(Venta venta) {
        return repository.save(venta);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    public Venta buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<Venta> listarPorEmpleado(Integer idEmpleado) {
        return repository.findVentasByEmpleado(idEmpleado);
    }

    public List<Venta> listarPorEmpleadoYFecha(Integer idEmpleado, LocalDate fecha) {
        return repository.findVentasByEmpleadoAndFecha(idEmpleado, fecha);
    }
}
