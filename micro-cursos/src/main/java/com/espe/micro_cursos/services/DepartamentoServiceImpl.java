package com.espe.micro_cursos.services;

import com.espe.micro_cursos.model.entity.Departamento;
import com.espe.micro_cursos.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> listarTodos() {
        return departamentoRepository.findAll();  // Método findAll() proporcionado por JpaRepository
    }

    @Override
    public Departamento guardarDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public Departamento obtenerPorId(Long id) {
        return departamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado con ID: " + id));
    }

    @Override
    public void eliminarPorId(Long id) {
        if (!departamentoRepository.existsById(id)) {
            throw new RuntimeException("Departamento no encontrado con ID: " + id);
        }
        departamentoRepository.deleteById(id);
    }

    @Override
    public List<Departamento> buscarPorNombre(String nombre) {
        return departamentoRepository.findByNombreContaining(nombre);
    }

    @Override
    public List<Departamento> buscarPorJefe(String jefe) {
        return departamentoRepository.findByJefeContaining(jefe);
    }

    @Override
    public List<Departamento> buscarPorEmpleados(int empleados) {
        return departamentoRepository.findByEmpleados(empleados);
    }
}
