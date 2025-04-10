package com.example.Papeleria.Repository;

import com.example.Papeleria.Model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    // Productos que ofrece un proveedor
    @Query(value = "SELECT * FROM producto p WHERE p.id_proveedor = ?1", nativeQuery = true)
    List<Object[]> findProductosByProveedor(Integer idProveedor);
}
