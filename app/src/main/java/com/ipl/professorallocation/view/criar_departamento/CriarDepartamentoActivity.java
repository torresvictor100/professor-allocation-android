package com.ipl.professorallocation.view.criar_departamento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ipl.professorallocation.data.DepartamentoRepositorio;
import com.ipl.professorallocation.databinding.ActivityCriarDepartamentoBinding;
import com.ipl.professorallocation.databinding.ActivityListarDepartamentoBinding;
import com.ipl.professorallocation.model.DepartamentRequest;

public class CriarDepartamentoActivity extends AppCompatActivity {

    private ActivityCriarDepartamentoBinding binding;
    private DepartamentoRepositorio departamentoRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCriarDepartamentoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        departamentoRepositorio = new DepartamentoRepositorio();
    }

    private void salvarDepartamento(){
        String nomedepartamento = binding.nomeCriarDepartamento.getText().toString();

        binding.buttonSalvarDepartamento.setOnClickListener(view -> {
            departamentoRepositorio.criarDepartamento(new DepartamentRequest(nomedepartamento));
        });
    }
}