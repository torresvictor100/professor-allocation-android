package com.ipl.professorallocation.data;

import android.util.Log;

import com.ipl.professorallocation.model.Professor;
import com.ipl.professorallocation.model.curso.Curso;
import com.ipl.professorallocation.model.curso.CursosRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CursoRepositorio {

    private final CursoService service;

    public CursoRepositorio() {
        service = RetrofitClient.getCursoService();
    }

    public void listarCursos(RespositorioCallBack<List<Curso>> respositorioCallBack) {
        Call<List<Curso>> call = service.listarCursos();
        call.enqueue(new Callback<List<Curso>>() {
            @Override
            public void onResponse(Call<List<Curso>> call, Response<List<Curso>> response) {
                List<Curso> list = response.body();
                respositorioCallBack.onResponse(list);
            }

            @Override
            public void onFailure(Call<List<Curso>> call, Throwable t) {
                respositorioCallBack.onFailure(t);
            }
        });
    }

    public void criarCurso(CursosRequest cursosRequest){
        Call<Curso> call = service.criarCourses(cursosRequest);
        call.enqueue(new Callback<Curso>() {
            @Override
            public void onResponse(Call<Curso> call, Response<Curso> response) {
                Log.d("IPL1", "onResponse sucesso: " + response.body());
            }

            @Override
            public void onFailure(Call<Curso> call, Throwable t) {
                Log.d("IPL1", "onResponse erro: " + t);
            }
        });
    }

    public void deletarCursos(int cursoId, RespositorioCallBack<Void> respositorioCallBack){
        Call<Void> call = service.deletarCourses(cursoId);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                respositorioCallBack.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                respositorioCallBack.onFailure(t);
            }
        });
    }
}
