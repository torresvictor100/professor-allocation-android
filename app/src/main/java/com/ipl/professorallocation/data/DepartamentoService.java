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

    @GET("/departaments")
    Call<List<Department>> listarTodosOsDepartamento();

    @DELETE("/departaments/{id}")
    Call<Void> deletarDepartamento(@Path("id") int departamentid);

    @POST("/departaments")
    Call<Department> criarDepartamento(@Body DepartamentRequest departamentRequest);
}
