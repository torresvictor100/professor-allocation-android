package com.ipl.professorallocation.data;

import android.renderscript.Allocation;

import com.ipl.professorallocation.model.AllocationRequest;
import com.ipl.professorallocation.model.AllocationsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AllocationService {

    @GET("/allocations")
    Call<List<AllocationsItem>> listarCursosAllocation();

    @GET("/allocations/{id}")
    Call<Allocation> buscarAllocacaoPorId(@Path("id") int allocacaoId);

    @DELETE("/allocations/{id}")
    Call<Void> deletarAllocacao(@Path("id") int allocacaoId);

    @POST("/allocations")
    Call<Allocation> criarAllocacao(@Body AllocationRequest allocationRequest);

    @PUT("/allocations/{id}")
    Call<Allocation> editarAllocacao(@Path("id") int allocationId, @Body AllocationRequest allocationRequest);

}
