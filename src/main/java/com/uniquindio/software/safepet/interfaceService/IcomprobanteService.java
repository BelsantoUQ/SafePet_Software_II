package com.uniquindio.software.safepet.interfaceService;

import com.uniquindio.software.safepet.modelo.Comprobante;

import java.util.List;
import java.util.Optional;

public interface IcomprobanteService {

    public List<Comprobante> listar();
    public Optional<Comprobante> listarId(int id);


}
