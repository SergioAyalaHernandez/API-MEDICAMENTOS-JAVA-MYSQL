package com.example.medicamentos.service;

import com.example.medicamentos.entity.Medicamento;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MedicamentoService {
    List<Medicamento> findAllMedicamentos();
    List<Medicamento> findById(Long id);
    Boolean deleteById(Long id);
    List<Medicamento> createMedicamento(Medicamento medicamento);
    List<Medicamento> updateMedicamento(Medicamento medicamento, Long id);

}
