package com.uniquindio.software.safepet.service;

import com.uniquindio.software.safepet.interfaceService.IveterinatiaService;
import com.uniquindio.software.safepet.interfaces.IVeterinaria;
import com.uniquindio.software.safepet.modelo.Veterinaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinariaService implements IveterinatiaService {
    @Autowired
    private IVeterinaria data;

    @Override
    public List<Veterinaria> listar() {
        return (List<Veterinaria>) data.findAll();
    }

    @Override
    public Optional<Veterinaria> listarId(int id) {

        return data.findById(id);
    }

    @Override
    public int save(Veterinaria veterinaria) {
        int respuesta= 0;
        Veterinaria asociado=data.save(veterinaria);
        if (!veterinaria.equals(null)){
            respuesta=1;
        }
        return respuesta;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
