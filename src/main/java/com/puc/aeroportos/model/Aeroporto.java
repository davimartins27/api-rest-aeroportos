package com.puc.aeroportos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aeroporto")
public class Aeroporto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAeroporto;

    @Column(nullable = false)
    private String nomeAeroporto;

    @Column(unique = true, length = 3, nullable = false)
    private String codigoIata;

    @Column(nullable = false)
    private String cidade;

    @Column(length = 2, nullable = false)
    private String codigoPaisIso;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private Double altitude;
}