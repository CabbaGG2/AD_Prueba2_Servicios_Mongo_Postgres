package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="personaxes")
public class Personaxe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpersonaxe;
    private String nome;
    private String stand;
    @ManyToOne
    @JoinColumn(name="idsaga")
    @JsonBackReference
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
