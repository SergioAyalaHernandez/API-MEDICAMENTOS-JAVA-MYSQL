package com.example.medicamentos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "medicamentos")
public class Medicamento {

    @Id
    @Column(name = "id_medicamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedicamento;
    @Column(name = "nombre_medicamento")
    private String nombreMedicamento;
    @Column(name = "url")
    private String url;
}
