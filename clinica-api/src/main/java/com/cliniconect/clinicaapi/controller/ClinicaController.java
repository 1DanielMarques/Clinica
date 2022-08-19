package com.cliniconect.clinicaapi.controller;

import com.cliniconect.clinicaapi.model.Endereco;
import com.cliniconect.clinicaapi.model.Paciente;
import com.cliniconect.clinicaapi.repository.PacienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinica")
public class ClinicaController {
    @Autowired
    private PacienteRepository pacienteRepository;


    @GetMapping
    public List<Paciente> read() {
        return pacienteRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente create(@RequestBody Paciente paciente) {
        Paciente p1 = new Paciente();
        BeanUtils.copyProperties(paciente,p1);
        p1.setEndereco(paciente.getEndereco());


        paciente.getEndereco();
        return pacienteRepository.save(paciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> update(@PathVariable Long id, @RequestBody Paciente paciente) {
        Paciente p = pacienteRepository.findById(id)
                .orElseThrow();

        p.setNome(paciente.getNome());
        p.setSexo(paciente.getSexo());
        p.setCpf(paciente.getCpf());
        p.setCelular(paciente.getCelular());
        p.setEmail(paciente.getEmail());

        pacienteRepository.save(p);

        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) {
        Paciente p = pacienteRepository.findById(id).orElseThrow();
        pacienteRepository.delete(p);
        return ResponseEntity.ok(id);
    }
}
