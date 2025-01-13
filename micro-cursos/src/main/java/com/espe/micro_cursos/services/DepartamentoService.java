package com.espe.micro_cursos.services;

import com.espe.micro_cursos.model.entity.Departamento;
import java.util.List;

public interface DepartamentoService {
    List<Departamento> listarTodos();  // Método para listar todos los departamentos
    Departamento guardarDepartamento(Departamento departamento);
    Departamento obtenerPorId(Long id);
    void eliminarPorId(Long id);
    List<Departamento> buscarPorNombre(String nombre);
    List<Departamento> buscarPorJefe(String jefe);
    List<Departamento> buscarPorEmpleados(int empleados);
}
