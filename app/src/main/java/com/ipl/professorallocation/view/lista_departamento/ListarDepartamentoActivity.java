package com.ipl.professorallocation.view.lista_departamento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.ipl.professorallocation.data.DepartamentoRepositorio;
import com.ipl.professorallocation.data.RespositorioCallBack;
import com.ipl.professorallocation.databinding.ActivityListarDepartamentoBinding;
import com.ipl.professorallocation.model.Department;
import com.ipl.professorallocation.view.lista_professores.ListarProfessoresAdapter;

import java.util.ArrayList;
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

    }

    public void configuracaoListaDepartamento(){
        adapter = new ListaDepartamentoAdapter(new ListaDepartamentoAdapter.CallBack() {
            @Override
            public void onDeleteClick(Department department) {
                departmentRepositorio.deletarDepartamento(department.getId(), new RespositorioCallBack<Void>() {
                    @Override
                    public void onResponse(Void response) {

                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });
            }

            @Override
            public void onEditeClick(Department department) {
                Log.d("joao", "onEditeClick: "+department);
            }
        });{

        }
    }

    public void listarDepartamento(){

        departmentRepositorio.listarDepartamento((new RespositorioCallBack<List<Department>>() {
            @Override
            public void onResponse(List<Department> response) {
                Log.d("IPL1", "onResponse sucesso c: " + response);
                adapter.addDepartament(response);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("IPL1", "onResponse erro c: " + t);
            }
        }));
    }
}