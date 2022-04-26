package com.ipl.professorallocation.view.lista_professores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.ipl.professorallocation.data.ProfessorRepositorio;
import com.ipl.professorallocation.data.RespositorioCallBack;
import com.ipl.professorallocation.databinding.ActivityListarProfessoresBinding;
import com.ipl.professorallocation.model.Professor;
import com.ipl.professorallocation.view.criar_professor.CriarProfessorActivity;

import java.util.List;

public class ListarProfessoresActivity extends AppCompatActivity {

    private ActivityListarProfessoresBinding binding;
    private ListarProfessoresAdapter adapter;
    private ProfessorRepositorio professorRepositorio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListarProfessoresBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        configuracaoListaProfessor();
        professorRepositorio = new ProfessorRepositorio();
        listarProfessor();
        binding.botaoAdicionar.setOnClickListener(view -> {
            Intent intent = new Intent(this, CriarProfessorActivity.class);
            startActivity(intent);
        });

    }

    public void configuracaoListaProfessor(){
        adapter = new ListarProfessoresAdapter(new ListarProfessoresAdapter.CallBack() {
            @Override
            public void onDeleteClick(Professor professor) {
                professorRepositorio.deletarProfessor(professor.getId(), new RespositorioCallBack<Void>() {
                    @Override
                    public void onResponse(Void response) {
                        adapter.removerProfessor(professor);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.d("professordelete", "Falho o delete "+ t);
                    }
                });
            }

            @Override
            public void onEditeClick(Professor professor) {
                Log.d("joao", "onEditeClick: "+ professor);
            }
        });
        binding.listaProfessor.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        binding.listaProfessor.setAdapter(adapter);
    }

    public void listarProfessor(){

        professorRepositorio.listarProfessores(new RespositorioCallBack<List<Professor>>() {
        @Override
        public void onResponse(List<Professor> response) {
            Log.d("IPL1", "onResponse sucesso c: " + response);
            adapter.addProfessor(response);
        }

        @Override
        public void onFailure(Throwable t) {
            Log.d("IPL1", "onResponse erro c: " + t);
        }
    });

    }



}