package com.uniquindio.software.safepet.modelo;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
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

    @ElementCollection
    @Column(nullable = false)
    private Map<String,String> beneficiario_mascota;

    public Afiliado(String nombre, String email, String password,
                    String num_telefono, Map<String, String> beneficiario_mascota) {
        super(nombre, email, password);
        this.num_telefono = num_telefono;
        this.beneficiario_mascota = beneficiario_mascota;
    }

    @OneToMany(mappedBy = "clienteAsociado")
    @ToString.Exclude
    private List<Historial> historialesConsulta;

    @OneToOne(mappedBy = "clienteAtencion")
    @ToString.Exclude
    private Comprobante planContratado;
}
