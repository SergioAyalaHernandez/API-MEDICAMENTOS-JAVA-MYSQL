package com.example.medicamentos.controller;

import com.example.medicamentos.entity.Medicamento;
import com.example.medicamentos.service.MedicamentoService;
import com.example.medicamentos.service.MedicamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/medicamento")
public class MedicamentoController {

    public MedicamentoService medicamentoService;
    @Autowired
    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }
    @GetMapping("/")
    public List<Medicamento> getUsers(){
        return medicamentoService.findAllMedicamentos();
    }

    @GetMapping("/byid/{id}")
    public List<Medicamento> getById(@PathVariable Long id){
        return medicamentoService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteById(@PathVariable Long id){
        return medicamentoService.deleteById(id);
    }

    @PostMapping("/")
    public List<Medicamento> createMedicamento(@RequestBody Medicamento medicamento){
        return medicamentoService.createMedicamento(medicamento);
    }

    @PutMapping("/{id}")
    public List<Medicamento> updateMedicamento(@RequestBody Medicamento medicamento, @PathVariable Long id){
        return medicamentoService.updateMedicamento(medicamento,id);
    }

}
