package com.uniquindio.software.safepet.interfaces;

import com.uniquindio.software.safepet.modelo.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlan extends CrudRepository<Plan, Integer> {
}
