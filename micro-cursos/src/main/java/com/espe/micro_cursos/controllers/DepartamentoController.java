package com.espe.micro_cursos.controllers;

import com.espe.micro_cursos.model.entity.Departamento;
import com.espe.micro_cursos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<Departamento>> obtenerTodosDepartamentos() {
        List<Departamento> departamentos = departamentoService.listarTodos();
        return new ResponseEntity<>(departamentos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Departamento> crearDepartamento(@RequestBody Departamento departamento) {
        Departamento nuevoDepartamento = departamentoService.guardarDepartamento(departamento);
        return new ResponseEntity<>(nuevoDepartamento, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> obtenerDepartamento(@PathVariable Long id) {
        Departamento departamento = departamentoService.obtenerPorId(id);
        return new ResponseEntity<>(departamento, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDepartamento(@PathVariable Long id) {
        departamentoService.eliminarPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
