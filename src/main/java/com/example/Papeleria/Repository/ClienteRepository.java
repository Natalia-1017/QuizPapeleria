package com.example.Papeleria.Repository;

import com.example.Papeleria.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
