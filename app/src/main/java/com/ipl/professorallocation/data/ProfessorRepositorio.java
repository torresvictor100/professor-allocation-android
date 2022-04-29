package com.ipl.professorallocation.data;

import android.util.Log;

import com.ipl.professorallocation.model.Professor;
import com.ipl.professorallocation.model.ProfessorRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfessorRepositorio {

    private final ProfessorService service;

    public ProfessorRepositorio() {
        service = RetrofitClient.getProfessorService();
    }

    public void listarProfessores(RespositorioCallBack<List<Professor>> respositorioCallBack) {
        Call<List<Professor>> call = service.listaTodosOsProfessores();
        call.enqueue(new Callback<List<Professor>>() {
            @Override
            public void onResponse(Call<List<Professor>> call, Response<List<Professor>> response) {
                List<Professor> list = response.body();
                respositorioCallBack.onResponse(list);
            }

            @Override
            public void onFailure(Call<List<Professor>> call, Throwable t) {
                respositorioCallBack.onFailure(t);
            }
        });
    }


    public void buscarProfessorPorId(int idProfessor, RespositorioCallBack<Professor> respositorioCallBack){
        Call<Professor> call = service.buscarProfessorId(idProfessor);
        call.enqueue(new Callback<Professor>() {
            @Override
            public void onResponse(Call<Professor> call, Response<Professor> response) {
                Log.d("buscarprofessor", "onResponse: Sucesso"+response );
                Professor pp = response.body();
                respositorioCallBack.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<Professor> call, Throwable t) {
                Log.d("buscarprofessor", "onFailure: falha ao buscar");
                respositorioCallBack.onFailure(t);
            }
        });
    }

    public void editaProfessor( int idProfessor , ProfessorRequest professorRequest, RespositorioCallBack<Professor> respositorioCallBack){
        Call<Professor> call = service.editaProfessor( idProfessor ,professorRequest);
        call.enqueue(new Callback<Professor>() {
            @Override
            public void onResponse(Call<Professor> call, Response<Professor> response) {
                Log.d("editarprofessor", "onResponse: editar sucesso");
                respositorioCallBack.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<Professor> call, Throwable t) {
                Log.d("editarprofessor", "onFailure: falhou edição professor");
                respositorioCallBack.onFailure(t);
            }
        });
    }

    public void criarProfessor(ProfessorRequest professorRequest, RespositorioCallBack<Professor> respositorioCallBack) {
        Call<Professor> call = service.criarProfessor(professorRequest);
        call.enqueue(new Callback<Professor>() {
            @Override
            public void onResponse(Call<Professor> call, Response<Professor> response) {
                Log.d("IPL1", "onResponse sucesso: " + response.body());
                respositorioCallBack.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<Professor> call, Throwable t) {
                Log.d("IPL1", "onResponse erro: " + t);
                respositorioCallBack.onFailure(t);
            }
        });
    }

    public void deletarProfessor(int professorId,RespositorioCallBack<Void> respositorioCallBack ) {
        Call<Void> call = service.deletarProfessor(professorId);
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
