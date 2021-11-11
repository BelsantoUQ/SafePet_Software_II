package com.uniquindio.software.safepet.interfaceService;


import com.uniquindio.software.safepet.modelo.Afiliado;
import com.uniquindio.software.safepet.modelo.Beneficiario;

import java.util.List;
import java.util.Optional;

public interface IbeneficiarioService {



    public List<Beneficiario> listar();
    public List<Beneficiario> listarPorAfiliado(Afiliado afiliado);
    public Optional<Beneficiario> listarId(int id);

}
