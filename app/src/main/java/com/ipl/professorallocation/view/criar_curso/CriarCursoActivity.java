package com.ipl.professorallocation.view.criar_curso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ipl.professorallocation.data.CursoRepositorio;
import com.ipl.professorallocation.databinding.ActivityCriarCursoBinding;
import com.ipl.professorallocation.databinding.ActivityCriarProfessorBinding;
import com.ipl.professorallocation.databinding.ActivityListaCursoBinding;
import com.ipl.professorallocation.model.curso.CursosRequest;

public class CriarCursoActivity extends AppCompatActivity {

    private ActivityCriarCursoBinding binding;
    private CursoRepositorio cursoRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCriarCursoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        cursoRepositorio = new CursoRepositorio();


    }

    private void salvarCurso(){
        String nome = binding.nomeCriarCurso.getText().toString();

        binding.buttonCriarCurso.setOnClickListener(view -> {
            cursoRepositorio.criarCurso(new CursosRequest(nome));
        });


    }
}