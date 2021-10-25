package com.uniquindio.software.safepet.modelo;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.io.Serializable;


@Entity
@NoArgsConstructor
@ToString(callSuper = true)
public class Empleado extends Persona implements Serializable {

    public Empleado(String nombre, String email, String password) {
        super(nombre, email, password);
    }
}
