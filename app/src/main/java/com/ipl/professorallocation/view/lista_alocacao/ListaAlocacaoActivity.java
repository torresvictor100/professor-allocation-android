package com.ipl.professorallocation.view.lista_alocacao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.renderscript.Allocation;
import android.util.Log;

import com.ipl.professorallocation.data.AllocationRepositorio;
import com.ipl.professorallocation.data.RespositorioCallBack;
import com.ipl.professorallocation.databinding.ActivityListaAlocacaoBinding;
import com.ipl.professorallocation.model.AllocationsItem;

import java.util.List;

public class ListaAlocacaoActivity extends AppCompatActivity {

    private ActivityListaAlocacaoBinding binding;
    private ListaAllocacaoAdapter adapter;
    private AllocationRepositorio allocationRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListaAlocacaoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        allocationRepositorio = new AllocationRepositorio();
        listarAlocacoes();
        setupOnCLickListener();
        setupRecyclerView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        listarAlocacoes();
    }

    private void setupRecyclerView() {
        adapter = new ListaAllocacaoAdapter(new ListaAllocacaoAdapter.RecyclerViewCallback() {
            @Override
            public void onClickExcluirAlocacao(AllocationsItem deletarAlocacao) {
                deletarAlocacao(deletarAlocacao);
            }

            @Override
            public void onClickEditarAlocacao(AllocationsItem editarAlocacaco) {

            }
        });
        binding.listaAlocacao.setAdapter(adapter);
        binding.listaAlocacao.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    private void deletarAlocacao(AllocationsItem allocation){
        allocationRepositorio.deletarAllocation(allocation.getId(), new RespositorioCallBack<Void>() {
            @Override
            public void onResponse(Void response) {
                adapter.removerUsuario(allocation);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("deletaallocations", "onFailure: falha ao deletar");
            }
        });
    }


    private void setupOnCLickListener(){
        binding.buttonAtualizarAlocacao.setOnClickListener(view -> {
            listarAlocacoes();
        });
        binding.buttonAdicionarAlocacao.setOnClickListener(view -> {});
    }

    private void listarAlocacoes(){
       allocationRepositorio.listaAllocation(new RespositorioCallBack<List<AllocationsItem>>() {
           @Override
           public void onResponse(List<AllocationsItem> response) {
               Log.d("IPL1", "onResponse sucesso c: " + response);
               adapter.addListaProfessor(response);
           }

           @Override
           public void onFailure(Throwable t) {
               Log.d("listaralocacao", "onFailure: falou a lista" + t);

           }
       });
    }
}