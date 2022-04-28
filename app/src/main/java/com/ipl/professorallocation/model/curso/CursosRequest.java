package com.ipl.professorallocation.model.curso;

import com.google.gson.annotations.SerializedName;

public class CursosRequest {

    @SerializedName("name")
    private String name;

    @SerializedName("sigla")
    private String sigla;

    public CursosRequest(String name,String sigla ){
        this.name = name;
        this.sigla = sigla;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSigla(){
        return sigla;
    }

    public void setSigla(String sigla){ this.sigla = sigla; }


    @Override
    public String toString(){
        return"CursoRequest{ "+ "name"+ name + "sigla"+ sigla + "}";
    }
}
