package com.uniquindio.software.safepet.interfaceService;
import com.uniquindio.software.safepet.modelo.Plan;
import com.uniquindio.software.safepet.modelo.Servicio;

import java.util.List;
import java.util.Optional;

public interface IservicioService {


    public List<Servicio> listar();
    public List<Servicio> listarPorPlan(Plan plan);
    public Optional<Servicio> listarId(int id);

}
