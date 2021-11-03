package com.uniquindio.software.safepet.service;

import com.uniquindio.software.safepet.interfaceService.IcomprobanteService;
import com.uniquindio.software.safepet.interfaces.IComprobante;
import com.uniquindio.software.safepet.modelo.Comprobante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComprobanteService implements IcomprobanteService {

    @Autowired
    private IComprobante data;

    @Override
    public List<Comprobante> listar() {
        return (List<Comprobante>) data.findAll();
    }

    @Override
    public Optional<Comprobante> listarId(int id) {

        return data.findById(id);
    }
}
