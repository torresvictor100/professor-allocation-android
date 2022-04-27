package com.ipl.professorallocation.view.lista_curso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.ipl.professorallocation.data.CursoRepositorio;
import com.ipl.professorallocation.data.RespositorioCallBack;
import com.ipl.professorallocation.databinding.ActivityListaCursoBinding;
import com.ipl.professorallocation.model.curso.Curso;
import com.ipl.professorallocation.view.criar_curso.CriarCursoActivity;

import java.util.ArrayList;
import java.util.List;

public class ListaCursoActivity extends AppCompatActivity {

    private ActivityListaCursoBinding binding;
    private ListaCursoAdapter adapter;
    private CursoRepositorio cursoRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListaCursoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        configuracaoListaCurso();
        cursoRepositorio = new CursoRepositorio();
        ListaCurso();
        binding.buttonCursoAdicionar.setOnClickListener(view -> {
            Intent intent = new Intent(this, CriarCursoActivity.class);
            startActivity(intent);
        });

    }
    public void configuracaoListaCurso(){
        adapter = new ListaCursoAdapter(new ListaCursoAdapter.CallBack() {
            @Override
            public void onDeleteClick(Curso curso) {
                cursoRepositorio.deletarCursos(curso.getId(), new RespositorioCallBack<Void>() {
                    @Override
                    public void onResponse(Void response) {
                        adapter.removeCurso(curso);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.d("cursodelete", "onFailure: o delete" + t);
                    }
                });
            }

            @Override
            public void onEditeClick(Curso curso) {
                Log.d("joao", "onEditeClick: "+curso);
            }
        });

        binding.listaCurso.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        binding.listaCurso.setAdapter(adapter);
    }

    public void ListaCurso() {
        cursoRepositorio.listarCursos(new RespositorioCallBack<List<Curso>>() {
            @Override
            public void onResponse(List<Curso> response) {
                Log.d("IPL1", "onResponse sucesso c: " + response);
                adapter.addCurso(response);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("IPL1", "onResponse erro c: " + t);
            }
        });
    }
}