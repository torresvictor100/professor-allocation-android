package com.ipl.professorallocation.data;

import com.ipl.professorallocation.model.Course;
import com.ipl.professorallocation.model.curso.Curso;
import com.ipl.professorallocation.model.curso.CursosRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CursoService {

    @GET("/courses")
    Call<List<Curso>> listarTodosOsCursos();

    @GET("/courses/{id}")
    Call<Curso> buscarCursoId(@Path("id") int cursoId);

    @DELETE("/courses/{id}")
    Call<Void> deletarCourses(@Path("id") int coursesId);

    @POST("/courses")
    Call<Curso> criarCourses(@Body CursosRequest coursesRequest);

    @PUT("/courses/{id}")
    Call<Curso> editarCurso( @Path("id") int  coursesId, @Body CursosRequest cursosRequest);
}
