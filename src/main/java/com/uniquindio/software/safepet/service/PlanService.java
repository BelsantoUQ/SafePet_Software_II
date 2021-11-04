package com.uniquindio.software.safepet.service;

import com.uniquindio.software.safepet.interfaceService.IplanService;
import com.uniquindio.software.safepet.interfaces.IPlan;
import com.uniquindio.software.safepet.modelo.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanService implements IplanService {

    @Autowired
    private IPlan data;

    @Override
    public List<Plan> listar() {
        return (List<Plan>) data.findAll();
    }

    @Override
    public Optional<Plan> listarId(int id) {

        return data.findById(id);
    }
}
