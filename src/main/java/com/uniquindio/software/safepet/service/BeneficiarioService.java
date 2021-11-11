package com.uniquindio.software.safepet.service;

import com.uniquindio.software.safepet.interfaceService.IbeneficiarioService;
import com.uniquindio.software.safepet.interfaces.IBeneficiario;
import com.uniquindio.software.safepet.modelo.Afiliado;
import com.uniquindio.software.safepet.modelo.Beneficiario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiarioService implements IbeneficiarioService {

    @Autowired
    private IBeneficiario data;

    @Override
    public List<Beneficiario> listar() {
        return (List<Beneficiario>) data.findAll();
    }

    @Override
    public List<Beneficiario> listarPorAfiliado(Afiliado afiliado) {

        return (List<Beneficiario>) data.findAllByBeneficiario(afiliado);

    }


    @Override
    public Optional<Beneficiario> listarId(int id) {

        return data.findById(id);
    }

}
