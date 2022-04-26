package com.ipl.professorallocation.model;

import com.google.gson.annotations.SerializedName;

public class ProfessorRequest {

    @SerializedName("cpf")
    private String cpf;

    @SerializedName("departmentId")
    private int idDepartamento;

    @SerializedName("name")
    private String name;

    public ProfessorRequest(String cpf, int idDepartamento, String name) {
        this.cpf = cpf;
        this.idDepartamento = idDepartamento;
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProfessorRequest{" +
                "cpf='" + cpf + '\'' +
                ", idDepartamento=" + idDepartamento +
                ", name='" + name + '\'' +
                '}';
    }
}
