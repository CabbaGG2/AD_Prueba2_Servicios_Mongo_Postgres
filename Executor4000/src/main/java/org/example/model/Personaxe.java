package org.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Personaxe {

    private Long idpersonaxe;

    private String nome;

    private String stand;

    private Saga saga;

    public Long getIdpersonaxe() {
        return idpersonaxe;
    }

    public void setIdpersonaxe(Long idpersonaxe) {
        this.idpersonaxe = idpersonaxe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStand() {
        return stand;
    }

    public void setStand(String stand) {
        this.stand = stand;
    }

    public Saga getSaga() {
        return saga;
    }

    public void setSaga(Saga saga) {
        this.saga = saga;
    }

}
