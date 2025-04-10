package com.example.Papeleria.Service;

import com.example.Papeleria.Model.Empleado;
import com.example.Papeleria.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> listar() {
        return empleadoRepository.findAll();
    }

    public Empleado guardar(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public void eliminar(Integer id) {
        empleadoRepository.deleteById(id);
    }

    public Empleado buscarPorId(Integer id) {
        return empleadoRepository.findById(id).orElse(null);
    }
}
