package com.ipl.professorallocation.data;

import com.ipl.professorallocation.model.Professor;
import com.ipl.professorallocation.model.ProfessorRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProfessorService {

    @GET("/professors")
    Call<List<Professor>> listaTodosOsProfessores();

    @GET("/professors/{id}")
    Call<Professor> buscarProfessorId(@Path("id") int professorId);

    @DELETE("/professors/{id}")
    Call<Void> deletarProfessor(@Path("id") int professorId);

    @POST("/professors")
    Call<Professor> criarProfessor(@Body ProfessorRequest professorRequest);

    @PUT("/professors/{id}")
    Call<Professor> editaProfessor( @Path("id") int professorId ,@Body ProfessorRequest professorRequest);
}
