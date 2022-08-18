package com.cliniconect.clinicaapi.repository;

import com.cliniconect.clinicaapi.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
