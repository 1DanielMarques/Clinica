package com.cliniconect.clinicaapi.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;


@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 200)
    private String nome;
    @Column(nullable = false)
    private String sexo;


    @ManyToMany
    @JoinTable(name = "paciente_endereco",
            joinColumns = @JoinColumn(name = "paciente_id"),
            inverseJoinColumns = @JoinColumn(name = "endereco_id"))
    @NotNull
    private List<Endereco> endereco;
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
        return endereco;
    }

    public void setEndereco(List endereco) {
        this.endereco = endereco;
    }
}
