package com.uniquindio.software.safepet.modelo;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString(callSuper = true)
public class Historial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @ManyToOne
    private Veterinaria veterinariaAsociada;

    @ManyToOne
    private Afiliado clienteAsociado;

    @ManyToOne
    private Servicio servicioContratado;

    @ManyToOne
    @ToString.Exclude
    private Beneficiario mascotaConsulta;

    public Historial(Veterinaria veterinariaAsociada, Afiliado clienteAsociado, Servicio servicioContratado, String nombreMascota) {
        this.veterinariaAsociada = veterinariaAsociada;
        this.clienteAsociado = clienteAsociado;
        this.servicioContratado = servicioContratado;
    }
}
