package com.ipl.professorallocation.view.lista_departamento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.ipl.professorallocation.data.DepartamentoRepositorio;
import com.ipl.professorallocation.data.RespositorioCallBack;
import com.ipl.professorallocation.databinding.ActivityListarDepartamentoBinding;
import com.ipl.professorallocation.model.Department;
import com.ipl.professorallocation.view.criar_departamento.CriarDepartamentoActivity;
import com.ipl.professorallocation.view.lista_professores.ListarProfessoresActivity;

import java.util.List;

public class ListarDepartamentoActivity extends AppCompatActivity {

    private ActivityListarDepartamentoBinding binding;
    private ListaDepartamentoAdapter adapter;
    private DepartamentoRepositorio departmentRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListarDepartamentoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        configuracaoListaDepartamento();
        departmentRepositorio = new DepartamentoRepositorio();
        listarDepartamento();
        binding.buttonAdicionar.setOnClickListener(view -> {
            Intent intent = new Intent(this, CriarDepartamentoActivity.class);
            startActivity(intent);
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        listarDepartamento();
    }

    public void configuracaoListaDepartamento(){
        adapter = new ListaDepartamentoAdapter(new ListaDepartamentoAdapter.CallBack() {
            @Override
            public void onDeleteClick(Department department) {
                departmentRepositorio.deletarDepartamento(department.getId(), new RespositorioCallBack<Void>() {
                    @Override
                    public void onResponse(Void response) {
                        adapter.removerDepartament(department);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.d("departamentdelete", "onFailure: o delete" + t);
                    }
                });
            }

            @Override
            public void onEditeClick(Department department) {
               Intent intent = new Intent(ListarDepartamentoActivity.this,CriarDepartamentoActivity.class);
               intent.putExtra("extra_id_departamento", department.getId());
               startActivity(intent);
            }
        });
        binding.listaDepartamentos.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        binding.listaDepartamentos.setAdapter(adapter);

    }

    public void listarDepartamento(){

        departmentRepositorio.listarDepartamento(new RespositorioCallBack<List<Department>>() {
            @Override
            public void onResponse(List<Department> response) {
                Log.d("IPL1", "onResponse sucesso c: " + response);
                adapter.addDepartament(response);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("IPL1", "onResponse erro c: " + t);
            }
        });
    }
}