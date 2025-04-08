package com.example.Papeleria.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpleado;

    private String nombre;
    private String cargo;
    private String telefono;

    @OneToMany(mappedBy = "empleado")
    private List<Venta> ventas;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado, String nombre, String cargo, String telefono, List<Venta> ventas) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.cargo = cargo;
        this.telefono = telefono;
        this.ventas = ventas;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", nombre='" + nombre + '\'' +
                ", cargo='" + cargo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", ventas=" + ventas +
                '}';
    }
}
