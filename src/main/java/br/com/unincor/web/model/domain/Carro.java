/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unincor.web.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "Carros")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id") //identifica o objeto por meio de um atributo

public class Carro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    @Column(name = "ano_fabricacao")
    private String anoFabricacao;
    @Column(name = "numero_chassi")
    private String numChassi;
    @Column(name = "numero_placa")
    private String numPlaca;
    @Column(name = "tipo_veiculo")
    @Enumerated(EnumType.STRING)
    private TipoVeiculo tipoVeiculo;
    @Column(name = "cor_carro")
    private String corCarro;
    @Column(name = "tipo_combustivel")
    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipoCombustivel;
     @Column(name = "tipo_transmissao")
    @Enumerated(EnumType.STRING)
    private TipoTransmissao tipoTransmissao;

}
