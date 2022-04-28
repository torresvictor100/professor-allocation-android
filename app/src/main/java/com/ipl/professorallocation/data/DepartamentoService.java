package com.ipl.professorallocation.data;

import com.ipl.professorallocation.model.DepartamentRequest;
import com.ipl.professorallocation.model.Department;
import com.ipl.professorallocation.model.curso.CursosRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DepartamentoService {

    @GET("/departments")
    Call<List<Department>> listarTodosOsDepartamento();

    @GET("/departments/{id}")
    Call<Department> buscarDepartmentId(@Path("id") int departamentId);

    @DELETE("/departments/{id}")
    Call<Void> deletarDepartamento(@Path("id") int departamentId);

    @POST("/departments")
    Call<Department> criarDepartamento(@Body DepartamentRequest departamentRequest);

    @PUT("/departments/{id}")
    Call<Department> editarDepartament( @Path("id") int  departamentId, @Body DepartamentRequest departamentRequest);
}
