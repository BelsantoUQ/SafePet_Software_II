package com.uniquindio.software.safepet.interfaces;

import com.uniquindio.software.safepet.modelo.Afiliado;
import com.uniquindio.software.safepet.modelo.Beneficiario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBeneficiario extends CrudRepository<Beneficiario, Integer> {

    List<Beneficiario> findAllByBeneficiario(Afiliado beneficiario);
}
