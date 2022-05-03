package com.ipl.professorallocation.data;

import android.renderscript.Allocation;
import android.util.Log;

import com.ipl.professorallocation.model.AllocationRequest;
import com.ipl.professorallocation.model.AllocationsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllocationRepositorio {

    private final AllocationService service;

    public AllocationRepositorio(){ service = RetrofitClient.getAllocationService();}

    public void listaAllocation(RespositorioCallBack<List<AllocationsItem>> respositorioCallBack ) {
        Call<List<AllocationsItem>> call = service.listarCursosAllocation();
        call.enqueue(new Callback<List<AllocationsItem>>() {

            @Override
            public void onResponse(Call<List<AllocationsItem>> call, Response<List<AllocationsItem>> response) {
                List<AllocationsItem> list = response.body();

                respositorioCallBack.onResponse(list);
            }

            @Override
            public void onFailure(Call<List<AllocationsItem>> call, Throwable t) {
                respositorioCallBack.onFailure(t);
            }
        });
    }

    public void criarAllocation(AllocationRequest allocationRequest, RespositorioCallBack<AllocationsItem> respositorioCallBack){
        Call<AllocationsItem> call = service.criarAllocacao(allocationRequest);
        call.enqueue(new Callback<AllocationsItem>() {
            @Override
            public void onResponse(Call<AllocationsItem> call, Response<AllocationsItem> response) {
                Log.d("allocationcriar", "onResponse: sucesso "+ response.body());
                respositorioCallBack.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<AllocationsItem> call, Throwable t) {
                Log.d("allocationcriar", "onFailure: "+ t);
                respositorioCallBack.onFailure(t);
            }
        });
    }

    public void buscarAllocation(int idAllocation, RespositorioCallBack respositorioCallBack){
        Call<AllocationsItem> call = service.buscarAllocacaoPorId(idAllocation);
        call.enqueue(new Callback<AllocationsItem>() {
            @Override
            public void onResponse(Call<AllocationsItem> call, Response<AllocationsItem> response) {
                Log.d("buscarallocation", "onResponse: Buscar"+ response);
                respositorioCallBack.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<AllocationsItem> call, Throwable t) {
                Log.d("buscarallocation", "onFailure: falha ao buscar allocation");
                respositorioCallBack.onFailure(t);
            }
        });
    }

    public void editarAllocation(int idAllocation, AllocationRequest allocationRequest, RespositorioCallBack respositorioCallBack ){
        Call<AllocationsItem> call = service.editarAllocacao(idAllocation, allocationRequest);
        call.enqueue(new Callback<AllocationsItem>() {
            @Override
            public void onResponse(Call<AllocationsItem> call, Response<AllocationsItem> response) {
                Log.d("edicaoallocation", "onResponse: edição com sucesso"+ response);
                respositorioCallBack.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<AllocationsItem> call, Throwable t) {
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
