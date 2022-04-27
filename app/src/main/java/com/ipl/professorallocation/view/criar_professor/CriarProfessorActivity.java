package com.ipl.professorallocation.view.criar_professor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ipl.professorallocation.data.ProfessorRepositorio;
import com.ipl.professorallocation.databinding.ActivityCriarProfessorBinding;
import com.ipl.professorallocation.model.ProfessorRequest;

public class CriarProfessorActivity extends AppCompatActivity {

    private  ActivityCriarProfessorBinding binding;
    private ProfessorRepositorio professorRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCriarProfessorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        professorRepositorio = new ProfessorRepositorio();

    }

    private void salvarProfessor(){
        String nomeprofessor =binding.nomeTextSalva.getText().toString();
        String cpfProfessor= binding.cpfTextSalva.getText().toString();
        String departamentpProfessor = binding.departamentoTextSalva.getText().toString();

        binding.buttonSalvar.setOnClickListener(view ->
        {professorRepositorio.criarProfessor(new ProfessorRequest(cpfProfessor,Integer.valueOf(departamentpProfessor),nomeprofessor));
        });
    }
}