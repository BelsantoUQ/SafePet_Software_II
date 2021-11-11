package com.uniquindio.software.safepet.interfaceService;
import com.uniquindio.software.safepet.modelo.Afiliado;
import com.uniquindio.software.safepet.modelo.Historial;

import java.util.List;
import java.util.Optional;

public interface IhistorialService {



    public List<Historial> listar();
    public List<Historial> listarPorAfiliado(Afiliado afiliado);
    public Optional<Historial> listarId(int id);
}
