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
    private VentaRepository ventaRepository;

    public List<Venta> listar() {
        return ventaRepository.findAll();
    }

    public Venta guardar(Venta venta) {
        return ventaRepository.save(venta);
    }

    public void eliminar(Integer id) {
        ventaRepository.deleteById(id);
    }

    public Venta buscarPorId(Integer id) {
        return ventaRepository.findById(id).orElse(null);
    }


    public List<Object[]> obtenerVentasPorEmpleado(Integer idEmpleado) {
        return ventaRepository.findVentasByEmpleado(idEmpleado);
    }

    public List<Object[]> obtenerVentasPorEmpleadoYFecha(Integer idEmpleado, LocalDate fecha) {
        return ventaRepository.findVentasByEmpleadoAndFecha(idEmpleado, fecha);
    }

}
