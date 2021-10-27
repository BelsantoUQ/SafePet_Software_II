package com.uniquindio.software.safepet.interfaces;

import com.uniquindio.software.safepet.modelo.Veterinaria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVeterinaria extends CrudRepository<Veterinaria, Integer> {

}
