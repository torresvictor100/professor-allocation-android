package com.ipl.professorallocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import com.ipl.professorallocation.databinding.ActivityMainBinding;
import com.ipl.professorallocation.view.lista_alocacao.ListaAlocacaoActivity;
import com.ipl.professorallocation.view.lista_curso.ListaCursoActivity;
import com.ipl.professorallocation.view.lista_departamento.ListarDepartamentoActivity;
import com.ipl.professorallocation.view.lista_professores.ListarProfessoresActivity;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupOnCardClickListener();
    }

    private void setupOnCardClickListener() {
        binding.cardViewProfessores.setOnClickListener(view -> {
            Intent intent = new Intent(this, ListarProfessoresActivity.class);
            startActivity(intent);
        });
        binding.cardViewCursos.setOnClickListener(view -> {
            Intent intent = new Intent(this,ListaCursoActivity.class);
            startActivity(intent);
        });
        binding.cardViewDepartamento.setOnClickListener(view -> {
            Intent intent = new Intent(this, ListarDepartamentoActivity.class);
            startActivity(intent);
        });
        binding.cardViewAlocacao.setOnClickListener(view -> {
            Intent intent = new Intent(this, ListaAlocacaoActivity.class);
            startActivity(intent);
        });

    }

}