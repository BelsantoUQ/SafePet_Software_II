package com.uniquindio.software.safepet.interfaces;

import com.uniquindio.software.safepet.modelo.Afiliado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPersona extends CrudRepository<Afiliado, Integer> {



}
