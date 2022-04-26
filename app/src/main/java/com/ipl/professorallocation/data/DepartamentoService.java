package com.ipl.professorallocation.data;

import com.ipl.professorallocation.model.DepartamentRequest;
import com.ipl.professorallocation.model.Department;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DepartamentoService {

    @GET("/departament")
    Call<List<Department>> listarTodosOsDepartamento();

    @DELETE("/departament/{id}")
    Call<Void> deletarDepartamento(@Path("id") int departamentid);

    @POST("/departament")
    Call<Department> criarDepartamento(@Body DepartamentRequest departamentRequest);
}
