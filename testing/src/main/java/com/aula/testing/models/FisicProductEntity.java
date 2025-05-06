package com.aula.testing.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FisicProductEntity extends ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double peso;
    @Column(nullable = false)
    private String dimensoes;

    public double CalcularFrete(double DistanciaKm){

        final double TaxaBase = 0.5; //Taxa por Km
        final double TaxaPorKg = 2.0; //Taxa por kilo
        final double TaxaMinima = 10.0;
        double CustoFrete = (peso*TaxaPorKg)+ (DistanciaKm * TaxaBase);
        return Math.max(CustoFrete, TaxaMinima);
    }

}
