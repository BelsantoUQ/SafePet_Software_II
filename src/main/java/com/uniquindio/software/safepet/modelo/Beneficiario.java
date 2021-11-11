package com.uniquindio.software.safepet.modelo;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString(callSuper = true)
public class Beneficiario implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 200)
    private String raza;

    @Column(nullable = false, length = 200)
    private String especie;

    @ManyToOne
    @ToString.Exclude
    private Afiliado beneficiario;

    @OneToMany(mappedBy = "mascotaConsulta")
    @ToString.Exclude
    private List<Historial> historiales;

    public Beneficiario(Integer codigo, String nombre, String raza, String especie) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.raza = raza;
        this.especie = especie;
    }
}
