package com.example.medicamentos.repository;

import com.example.medicamentos.entity.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentosRepository extends JpaRepository<Medicamento,Long> {

}
