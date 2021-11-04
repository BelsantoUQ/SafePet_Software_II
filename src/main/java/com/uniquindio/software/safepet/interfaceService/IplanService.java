package com.uniquindio.software.safepet.interfaceService;

import com.uniquindio.software.safepet.modelo.Plan;

import java.util.List;
import java.util.Optional;

public interface IplanService {

    public List<Plan> listar();
    public Optional<Plan> listarId(int id);
}
