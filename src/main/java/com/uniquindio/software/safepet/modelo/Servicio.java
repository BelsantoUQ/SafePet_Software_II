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
public class Servicio implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false, length = 100)
    private String nombre;

    private float calificacion;

    @Column(nullable = false)
    private double costo_en_plan;

    @Column(nullable = false)
    private double copago;

    @ManyToOne
    private Plan planActual;

    @OneToMany(mappedBy = "servicioContratado")
    @ToString.Exclude
    private List<Historial> historialesAsociados;

    public Servicio(String nombre, double costo_en_plan, double copago) {
        this.nombre = nombre;
        this.costo_en_plan = costo_en_plan;
        this.copago = copago;
    }
}
