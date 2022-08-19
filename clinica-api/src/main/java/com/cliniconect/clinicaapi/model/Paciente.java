package com.cliniconect.clinicaapi.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;


@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String nome;
    @Column(nullable = false)
    private String sexo;
    @OneToMany(mappedBy = "paciente")
    @Column(nullable = false)
    private List<Endereco> enderecos;
    @Column(nullable = false, length = 11)
    private String cpf;
    @Column(nullable = false, length = 11)
    private String celular;
    //@Column(nullable = false)
//    private Date dataNascimento;
    @Column(nullable = false, length = 50)
    private String email;

    public Long getId() {
        return id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    /*public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }*/
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List getEndereco() {
        return enderecos;
    }

    public void setEndereco(List enderecos) {
        this.enderecos = enderecos;
    }
}
