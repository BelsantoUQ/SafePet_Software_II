package com.uniquindio.software.safepet.interfaceService;


import com.uniquindio.software.safepet.modelo.Veterinaria;

import java.util.List;
import java.util.Optional;

public interface IveterinatiaService {
    public List<Veterinaria> listar();
    public Optional<Veterinaria> listarId(int id);
    public int save(Veterinaria veterinaria);
    public void delete(int id);
}
