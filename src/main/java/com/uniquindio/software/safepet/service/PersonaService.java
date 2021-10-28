package com.uniquindio.software.safepet.service;

import com.uniquindio.software.safepet.interfaceService.IpersonaService;
import com.uniquindio.software.safepet.interfaces.IPersona;
import com.uniquindio.software.safepet.modelo.Afiliado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IpersonaService {

    @Autowired
    private IPersona data;

    @Override
    public Optional<Afiliado> validar(String email, String password) {

        return data.findByEmailAndAndPassword(email,password);
    }

    @Override
    public List<Afiliado> listar() {
        return (List<Afiliado>) data.findAll();
    }

    @Override
    public Optional<Afiliado> listarId(int id) {

        return data.findById(id);
    }

    @Override
    public int save(Afiliado afiliado) {
        int respuesta= 0;
        Afiliado cliente=data.save(afiliado);
        if (!afiliado.equals(null)){
            respuesta=1;
        }
        return respuesta;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
