package com.ipl.professorallocation.model;

import com.google.gson.annotations.SerializedName;

public class DepartamentRequest {

    @SerializedName("name")
    private String name;

    @SerializedName("area")
    private String area;

    @SerializedName("sigla")
    private String sigla;

    public DepartamentRequest(String area, String name,  String sigla) {
        this.area = area;
        this.name = name;
        this.sigla = sigla;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea(){ return  area;}

    public void setArea(){ this.area = area;}

    public String getSigla(){return sigla;}

    public void setSigla(){this.sigla = sigla;}


    @Override
    public String toString(){
        return "DepartamentoRequest{" + "nome" + name +"area "+ area +"sigla"+sigla+"}";
    }
}
