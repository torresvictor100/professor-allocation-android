package com.ipl.professorallocation.data;

import android.util.Log;

import com.ipl.professorallocation.model.curso.Curso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CursoRepositorio {

    private final CursoService service;

    public CursoRepositorio() {
        service = RetrofitClient.getCursoService();
    }

    private void listarCursos() {
        Call<List<Curso>> call = service.listarCursos();
        call.enqueue(new Callback<List<Curso>>() {
            @Override
            public void onResponse(Call<List<Curso>> call, Response<List<Curso>> response) {
                Log.d("IPL1", "onResponse sucesso: " + response.body());
            }

            @Override
            public void onFailure(Call<List<Curso>> call, Throwable t) {
                Log.d("IPL1", "onFailure error: " + t);
            }
        });
    }
}
