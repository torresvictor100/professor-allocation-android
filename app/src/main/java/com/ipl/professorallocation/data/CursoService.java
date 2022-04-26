package com.ipl.professorallocation.data;

import com.ipl.professorallocation.model.curso.Curso;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CursoService {

    @GET("/courses")
    Call<List<Curso>> listarCursos();
}
