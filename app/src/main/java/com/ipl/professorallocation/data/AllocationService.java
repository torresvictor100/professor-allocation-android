package com.ipl.professorallocation.data;

import android.renderscript.Allocation;

import com.ipl.professorallocation.model.curso.AllocationsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AllocationService {

    @GET("/allocation")
    Call<List<Allocation>> listarCursosAllocation();

    @GET("/allocation/{id}")
    Call<Allocation> buscarAllocacaoPorId(@Path("id") int allocacaoId);

    @DELETE("/allocation/{id}")
    Call<Void> deletarAllocacao(@Path("id") int allocacaoId);

    @POST("/allocation")
    Call<Allocation> criarAllocacao(@Body AllocationsItem allocationsItem);

    @PUT("/allocation/{id}")
    Call<Allocation> editarAllocacao(@Path("id") int allocationId, @Body AllocationsItem allocationsItem);

}
