package com.example.Papeleria.Service;

import com.example.Papeleria.Model.DetalleVenta;
import com.example.Papeleria.Repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository repository;

    public List<DetalleVenta> listar() {
        return repository.findAll();
    }

    public DetalleVenta guardar(DetalleVenta detalle) {
        return repository.save(detalle);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    public DetalleVenta buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<Object[]> listarClientesConDetalle() {
        return repository.listarClientesConDetalles();
    }
}
