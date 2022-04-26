package com.ipl.professorallocation.view.lista_curso;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.ipl.professorallocation.data.CursoRepositorio;
import com.ipl.professorallocation.data.RespositorioCallBack;
import com.ipl.professorallocation.databinding.ActivityListarCursosBinding;
import com.ipl.professorallocation.model.curso.Curso;
import com.ipl.professorallocation.view.criar_professor.CriarProfessorActivity;

import java.util.List;

public class ListaCursoActivity  extends AppCompatActivity {

    private ActivityListarCursosBinding binding;
    private ListaCursoAdapter adapter;
    private CursoRepositorio cursoRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        configuracaoListaCurso();
        cursoRepositorio = new CursoRepositorio();
        listarCurso();
        binding.buttonAdicionarCurso.setOnClickListener(view -> {

        });


    }
    public void configuracaoListaCurso(){
        adapter = new ListaCursoAdapter(new ListaCursoAdapter.CallBack() {
            @Override
            public void onDeleteClick(Curso curso) {
                cursoRepositorio.deletarCursos(curso.getId(), new RespositorioCallBack<Void>() {
                    @Override
                    public void onResponse(Void response) {
                        adapter.removerCurso(curso);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.d("professordelete", "Falho o delete "+ t);
                    }
                });
            }

            @Override
            public void onEditeClick(Curso curso) {

            }
        });
    }

    public void listarCurso(){
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
