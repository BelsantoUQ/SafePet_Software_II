package com.uniquindio.software.safepet.interfaces;

import com.uniquindio.software.safepet.modelo.Afiliado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPersona extends CrudRepository<Afiliado, Integer> {


   // @Query("select * from Afiliado where password = :password and u.email= :email")
    //List<Afiliado> validarInicioSesion(String password, String email);
    Optional<Afiliado> findByEmailAndAndPassword(String email, String password);

}
