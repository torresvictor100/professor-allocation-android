package com.ipl.professorallocation.data;

import android.renderscript.Allocation;
import android.util.Log;

import com.ipl.professorallocation.model.curso.AllocationsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllocationRepositorio {

    private final AllocationService service;

    public AllocationRepositorio(){ service = RetrofitClient.getAllocationService();}

    public void listaAllocation(RespositorioCallBack<List<Allocation>> respositorioCallBack ) {
        Call<List<Allocation>> call = service.listarCursosAllocation();
        call.enqueue(new Callback<List<Allocation>>() {
            @Override
            public void onResponse(Call<List<Allocation>> call, Response<List<Allocation>> response) {
                List<Allocation> list = response.body();
                respositorioCallBack.onResponse(list);
            }

            @Override
            public void onFailure(Call<List<Allocation>> call, Throwable t) {
                respositorioCallBack.onFailure(t);
            }
        });
    }

    public void criarAllocation(AllocationsItem allocationsItem, RespositorioCallBack<Allocation> respositorioCallBack){
        Call<Allocation> call = service.criarAllocacao(allocationsItem);
        call.enqueue(new Callback<Allocation>() {
            @Override
            public void onResponse(Call<Allocation> call, Response<Allocation> response) {
                Log.d("allocationcriar", "onResponse: sucesso "+ response.body());
                respositorioCallBack.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<Allocation> call, Throwable t) {
                Log.d("allocationcriar", "onFailure: "+ t);
                respositorioCallBack.onFailure(t);
            }
        });
    }

    public void buscarAllocation(int idAllocation, RespositorioCallBack respositorioCallBack){
        Call<Allocation> call = service.buscarAllocacaoPorId(idAllocation);
        call.enqueue(new Callback<Allocation>() {
            @Override
            public void onResponse(Call<Allocation> call, Response<Allocation> response) {
                Log.d("buscarallocation", "onResponse: Buscar"+ response);
                respositorioCallBack.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<Allocation> call, Throwable t) {
                Log.d("buscarallocation", "onFailure: falha ao buscar allocation");
                respositorioCallBack.onFailure(t);
            }
        });
    }

    public void editarAllocation(int idAllocation, AllocationsItem allocationsItem,RespositorioCallBack respositorioCallBack ){
        Call<Allocation> call = service.editarAllocacao(idAllocation, allocationsItem);
        call.enqueue(new Callback<Allocation>() {
            @Override
            public void onResponse(Call<Allocation> call, Response<Allocation> response) {
                Log.d("edicaoallocation", "onResponse: edição com sucesso"+ response);
                respositorioCallBack.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<Allocation> call, Throwable t) {
                Log.d("edicaoallocation" , "onFailure: falhou a edição");
                respositorioCallBack.onFailure(t);
            }
        });
    }

    public void deletarAllocation(int allocationId, RespositorioCallBack<Void> respositorioCallBack){
        Call<Void> call = service.deletarAllocacao(allocationId);
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
