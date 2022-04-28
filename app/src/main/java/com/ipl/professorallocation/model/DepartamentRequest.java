package com.ipl.professorallocation.model;

import com.google.gson.annotations.SerializedName;

public class DepartamentRequest {

    @SerializedName("name")
    private String name;

    public DepartamentRequest(String name) {
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
        return "DepartamentoRequest{" + "nome" + name +"}";
    }
}
