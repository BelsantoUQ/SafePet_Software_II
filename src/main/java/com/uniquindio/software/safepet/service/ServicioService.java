package com.uniquindio.software.safepet.service;

import com.uniquindio.software.safepet.interfaceService.IservicioService;
import com.uniquindio.software.safepet.interfaces.IPlan;
import com.uniquindio.software.safepet.interfaces.IServicio;
import com.uniquindio.software.safepet.modelo.Plan;
import com.uniquindio.software.safepet.modelo.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService implements IservicioService {

    @Autowired
    private IServicio data;

    @Override
    public List<Servicio> listar() {
        return (List<Servicio>) data.findAll();
    }


    @Override
    public List<Servicio> listarPorPlan(Plan plan) {

        return (List<Servicio>) data.findAllByPlanActual(plan);

    }


    @Override
    public Optional<Servicio> listarId(int id) {

        return data.findById(id);
    }

}
