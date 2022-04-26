package com.ipl.professorallocation.model.curso;

import com.google.gson.annotations.SerializedName;

public class CursosRequest {

    @SerializedName("name")
    private String name;

    public CursosRequest(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString(){
        return"CursoRequest{ "+ "name"+ "}";
    }
}
