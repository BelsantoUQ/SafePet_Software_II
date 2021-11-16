package com.uniquindio.software.safepet.interfaceService;

import com.uniquindio.software.safepet.modelo.Afiliado;

import java.util.List;
import java.util.Optional;


public interface IpersonaService {

    public List<Afiliado> listar();
    public Optional<Afiliado> listarId(int id);
    public int save(Afiliado afiliado);
    public boolean delete(int id);
}
