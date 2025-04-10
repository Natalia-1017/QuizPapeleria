package com.example.Papeleria.Service;

import com.example.Papeleria.Model.Cliente;
import com.example.Papeleria.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public Cliente guardar(Cliente cliente) {
        return repository.save(cliente);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    public Cliente buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
