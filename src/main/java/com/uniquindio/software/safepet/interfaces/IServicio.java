package com.uniquindio.software.safepet.interfaces;

import com.uniquindio.software.safepet.modelo.Plan;
import com.uniquindio.software.safepet.modelo.Servicio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IServicio extends CrudRepository<Servicio, Integer> {

    List<Servicio> findAllByPlanActual(Plan plan);

}
