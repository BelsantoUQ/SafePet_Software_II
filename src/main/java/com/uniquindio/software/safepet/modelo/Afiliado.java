package com.uniquindio.software.safepet.modelo;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString(callSuper = true)
public class Afiliado extends Persona implements Serializable {


    @Column(nullable = false, length = 100)
    private String num_telefono;

    @OneToMany(mappedBy = "beneficiario")
    @ToString.Exclude
    private List<Beneficiario> mascotas;

    public Afiliado(String nombre, String email, String password,
                    String num_telefono) {
        super(nombre, email, password);
        this.num_telefono = num_telefono;
    }

    @OneToMany(mappedBy = "clienteAsociado")
    @ToString.Exclude
    private List<Historial> historialesConsulta;

    @OneToOne(mappedBy = "clienteAtencion")
    @ToString.Exclude
    private Comprobante planContratado;
}
