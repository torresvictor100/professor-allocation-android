package com.ipl.professorallocation.view.criar_allocation.criar_alocacao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.ipl.professorallocation.data.DepartamentoRepositorio;
import com.ipl.professorallocation.data.ProfessorRepositorio;
import com.ipl.professorallocation.databinding.ActivityCriarAlocacaoBinding;
import com.ipl.professorallocation.model.Department;

import java.time.LocalTime;

public class CriarAlocacaoActivity extends AppCompatActivity {

    private ActivityCriarAlocacaoBinding binding;
    private ArrayAdapter<Department> departamentoSpinner;
    private DepartamentoRepositorio departamentoRepositorio;
    private ProfessorRepositorio professorRepositorio;
    public static final String EXTRA_EDITAR_PROFESSOR = "editar_professor";


    private LocalTime timeInicoSelecionada;
    private LocalTime timeFimSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }
}