package com.espe.micro_cursos.repositories;

import com.espe.micro_cursos.model.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    List<Departamento> findByNombreContaining(String nombre);
    List<Departamento> findByJefeContaining(String jefe);
    List<Departamento> findByEmpleados(int empleados);
}
