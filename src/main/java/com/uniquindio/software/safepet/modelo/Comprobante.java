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
public class Comprobante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @OneToOne
    @ToString.Exclude
    @JoinColumn(name = "id_afiliado")
    private Afiliado clienteAtencion;

    @OneToOne
    @ToString.Exclude
    @JoinColumn(name = "id_plan")
    private Plan planContratado;

    @Column(nullable = false)
    private MedioPago medio_de_pago;

    public Comprobante(Afiliado clienteAsociado, Plan planContratado, MedioPago medio_de_pago) {
        this.clienteAtencion = clienteAsociado;
        this.planContratado = planContratado;
        this.medio_de_pago = medio_de_pago;
    }
}
