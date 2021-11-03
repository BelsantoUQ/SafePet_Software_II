package com.uniquindio.software.safepet.interfaces;

import com.uniquindio.software.safepet.modelo.Comprobante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComprobante extends CrudRepository <Comprobante, Integer> {

}
