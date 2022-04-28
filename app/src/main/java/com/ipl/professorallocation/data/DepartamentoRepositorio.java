package com.ipl.professorallocation.data;

import android.util.Log;

import com.ipl.professorallocation.model.DepartamentRequest;
import com.ipl.professorallocation.model.Department;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class DepartamentoRepositorio {

    private final DepartamentoService service;

    public  DepartamentoRepositorio(){service = RetrofitClient.getDepartamentoService();}

    public void listarDepartamento(RespositorioCallBack<List<Department>> respositorioCallBack){
        Call<List<Department>> call = service.listarTodosOsDepartamento();
        call.enqueue(new Callback<List<Department>>() {
            @Override
            public void onResponse(Call<List<Department>> call, Response<List<Department>> response) {
                List<Department> list = response.body();
                respositorioCallBack.onResponse(list);
            }

            @Override
            public void onFailure(Call<List<Department>> call, Throwable t) {
                respositorioCallBack.onFailure(t);
            }
        });
    }

    public void criarDepartamento(DepartamentRequest departamentRequest, RespositorioCallBack<Department> respositorioCallBack){
        DepartamentRequest oque = departamentRequest;
        Call<Department> call = service.criarDepartamento(departamentRequest);
        call.enqueue(new Callback<Department>() {
            @Override
            public void onResponse(Call<Department> call, Response<Department> response) {
                Log.d("IPL1", "onResponse sucesso: " + response.body());
                respositorioCallBack.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<Department> call, Throwable t) {
                Log.d("IPL1", "onResponse erro: " + t);
                respositorioCallBack.onFailure(t);
            }
        });
    }


    public void buscarDepartamento(int idDepartament, RespositorioCallBack respositorioCallBack ){
        Call<Department> call = service.buscarDepartmentId(idDepartament);
        call.enqueue(new Callback<Department>() {
            @Override
            public void onResponse(Call<Department> call, Response<Department> response) {
                Log.d("buscadepartament", "onResponse: Sucesso"+ response);
                respositorioCallBack.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<Department> call, Throwable t) {
                Log.d("buscadepartament", "onFailure: falha ao buscar departamento");
                respositorioCallBack.onFailure(t);
            }
        });
    }

    public void editaDepartamento(int IdDepartament, DepartamentRequest departamentRequest, RespositorioCallBack respositorioCallBack){
        Call<Department> call = service.editarDepartament(IdDepartament, departamentRequest);
        call.enqueue(new Callback<Department>() {
            @Override
            public void onResponse(Call<Department> call, Response<Department> response) {
                Log.d("edicaodepartamento", "onResponse: edição com sicesso"+ response);
                respositorioCallBack.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<Department> call, Throwable t) {
                Log.d("edicaodepartamento", "onFailure: falhou a edicão");
                respositorioCallBack.onFailure(t);
            }
        });
    }

    public void deletarDepartamento( int IdDepartament ,RespositorioCallBack<Void> respositorioCallBack ){
        Call<Void> call = service.deletarDepartamento(IdDepartament);
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
