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
public class Plan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @ManyToMany(mappedBy = "planActual")
    @ToString.Exclude
    private List<Servicio> servicios;

    @Column(nullable = false)
    private Integer numeroBeneficiarios;

    @Column(nullable = false)
    private double costoTotal;

    public Plan(List<Servicio> servicios, Integer numeroBeneficiarios, double costoTotal) {
        this.servicios = servicios;
        this.numeroBeneficiarios = numeroBeneficiarios;
        this.costoTotal = costoTotal;
    }

    @OneToOne(mappedBy = "planContratado")
    @ToString.Exclude
    private Comprobante detallePlan;

}
