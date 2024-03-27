package com.example.medicamentos.service;

import com.example.medicamentos.entity.Medicamento;
import com.example.medicamentos.repository.MedicamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoServiceImpl implements MedicamentoService{

    private final MedicamentosRepository medicamentosRepository;

    @Autowired
    public MedicamentoServiceImpl(MedicamentosRepository medicamentosRepository) {
        this.medicamentosRepository = medicamentosRepository;
    }


    @Override
    public List<Medicamento> findAllMedicamentos() {
        return medicamentosRepository.findAll();
    }

    @Override
    public List<Medicamento> findById(Long id) {
        return medicamentosRepository.findAllById(Collections.singleton(id));
    }

    @Override
    public Boolean deleteById(Long id) {
        try {
            medicamentosRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Medicamento> createMedicamento(Medicamento medicamento) {
        return Collections.singletonList(medicamentosRepository.save(medicamento));
    }

    @Override
    public List<Medicamento> updateMedicamento(Medicamento medicamento, Long id) {
        Optional<Medicamento> optionalMedicamento = medicamentosRepository.findById(id);
        if (optionalMedicamento.isPresent()) {
            Medicamento medicamentoExistente = optionalMedicamento.get();
            medicamentoExistente.setNombreMedicamento(medicamento.getNombreMedicamento());
            medicamentoExistente.setUrl(medicamento.getUrl());
            medicamentosRepository.save(medicamentoExistente);
            return medicamentosRepository.findAll();
        } else {
            throw new RuntimeException("No se encontró el medicamento con el ID proporcionado: " + id);
        }
    }

}
