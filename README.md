# QuizPapeleria


•	Consulta nativa: Para listar clientes con sus detalles de venta


@Query(value = "SELECT c.nombre, c.correo, d.cantidad, p.nombre AS producto " +
"FROM cliente c " +
"JOIN venta v ON c.id_cliente = v.id_cliente " +
"JOIN detalle_venta d ON v.id_venta = d.id_venta " +
"JOIN producto p ON d.id_producto = p.id_producto",
nativeQuery = true)
    List<Object[]> listarClientesConDetalles();

DetalleVentaController
Tipo de petición: GET
Ruta: /api/detalles/consulta/clientes-detalles
URL DE EJEMPLO: http://localhost:8080/api/detalles/consulta/clientes-detalles


•	Consulta nativa:Para obtener ventas de un empleado con sus clientes

@Query("SELECT v.idVenta, v.fecha, c.nombre " +
"FROM Venta v JOIN v.cliente c " +
"WHERE v.empleado.idEmpleado = :idEmpleado")
List<Object[]> findVentasByEmpleado(@Param("idEmpleado") Integer idEmpleado);

VentaController
Tipo de petición:GET
Ruta:/empleado/{idEmpleado}
URL EJEMPLO: http://localhost:8080/api/ventas/empleado/1


•	Consulta nativa: Para obtener ventas de un empleado por fecha

@Query("SELECT v.idVenta, v.fecha, c.nombre " +
"FROM Venta v JOIN v.cliente c " +
"WHERE v.empleado.idEmpleado = :idEmpleado AND v.fecha = :fecha")
List<Object[]> findVentasByEmpleadoAndFecha(@Param("idEmpleado") Integer idEmpleado,
@Param("fecha") LocalDate fecha);

VentaController
Tipo de petición:GET
Ruta:/empleado/{idEmpleado}/fecha/{fecha}
URL EJEMPLO: http://localhost:8080/api/ventas/empleado/1/fecha/2025-04-01



•	Consulta nativa: Para obtener Productos que ofrece un proveedor

@Query(value = "SELECT * FROM producto p WHERE p.id_proveedor = ?1", nativeQuery = true)
List<Object[]> findProductosByProveedor(Integer idProveedor);

ProveedorController
Tipo de petición:GET
Ruta:/api/proveedores/{idProveedor}/productos
URL DE EJEMPLO: http://localhost:8080/api/proveedores/1/productos 




