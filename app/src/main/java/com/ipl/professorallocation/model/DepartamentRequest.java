package com.ipl.professorallocation.model;

import com.google.gson.annotations.SerializedName;

public class DepartamentRequest {

    @SerializedName("nome")
    private String nome;

    public DepartamentRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString(){
        return "DepartamentoRequest{" + "nome" + nome +"}";
    }
}
