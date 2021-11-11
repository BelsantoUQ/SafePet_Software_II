package com.uniquindio.software.safepet.interfaces;

import com.uniquindio.software.safepet.modelo.Afiliado;
import com.uniquindio.software.safepet.modelo.Historial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHistorial extends CrudRepository<Historial, Integer> {

    List<Historial> findAllByClienteAsociado(Afiliado afiliado);
    
}
