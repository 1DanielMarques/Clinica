package com.cliniconect.clinicaapi.repository;

import com.cliniconect.clinicaapi.model.Paciente;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    @Query("select p from Paciente p where p.nome LIKE %?1% ")
    List<Paciente> buscaNome(String nome);

    @Query(" select p from Paciente p where p.cpf LIKE %?1% ")
    List<Paciente> buscaCpf(String cpf);

    @Query(" select p from Paciente p where p.email LIKE %?1% ")
    List<Paciente> buscaEmail(String email);
}
