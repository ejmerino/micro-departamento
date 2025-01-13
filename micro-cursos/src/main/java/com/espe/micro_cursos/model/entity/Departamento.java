package com.espe.micro_cursos.model.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String jefe; // Agregado el campo 'jefe'
    private int empleados; // Cambiado de 'numeroEmpleados' a 'empleados'

    @Temporal(TemporalType.TIMESTAMP)
    private Date creadoEn;

    // Constructor vacío
    public Departamento() {}

    // Constructor con parámetros
    public Departamento(String nombre, String jefe, int empleados, Date creadoEn) {
        this.nombre = nombre;
        this.jefe = jefe;
        this.empleados = empleados;
        this.creadoEn = creadoEn;
    }

    // Método para inicializar creadoEn antes de persistir
    @PrePersist
    protected void prePersist() {
        if (this.creadoEn == null) {
            this.creadoEn = new Date();
        }
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getJefe() {
        return jefe;
    }

    public void setJefe(String jefe) {
        this.jefe = jefe;
    }

    public int getEmpleados() {
        return empleados;
    }

    public void setEmpleados(int empleados) {
        this.empleados = empleados;
    }

    public Date getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }
}
