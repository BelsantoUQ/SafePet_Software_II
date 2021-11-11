package com.uniquindio.software.safepet.service;
import com.uniquindio.software.safepet.interfaceService.IhistorialService;
import com.uniquindio.software.safepet.interfaces.IHistorial;
import com.uniquindio.software.safepet.modelo.Afiliado;
import com.uniquindio.software.safepet.modelo.Historial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialService implements IhistorialService {

    @Autowired
    private IHistorial data;

    @Override
    public List<Historial> listar() {
        return (List<Historial>) data.findAll();
    }

    @Override
    public List<Historial> listarPorAfiliado(Afiliado afiliado) {

        return (List<Historial>) data.findAllByClienteAsociado(afiliado);

    }

    @Override
    public Optional<Historial> listarId(int id) {

        return data.findById(id);
    }

}
