package com.ipl.professorallocation.view.criar_departamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ipl.professorallocation.data.DepartamentoRepositorio;
import com.ipl.professorallocation.data.RespositorioCallBack;
import com.ipl.professorallocation.databinding.ActivityCriarDepartamentoBinding;
import com.ipl.professorallocation.databinding.ActivityListarDepartamentoBinding;
import com.ipl.professorallocation.model.DepartamentRequest;
import com.ipl.professorallocation.model.Department;

public class CriarDepartamentoActivity extends AppCompatActivity {

    private ActivityCriarDepartamentoBinding binding;
    private DepartamentoRepositorio departamentoRepositorio;
    private int idDepartamento = -1;
    private Department editarDepartment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCriarDepartamentoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        departamentoRepositorio = new DepartamentoRepositorio();
        salvarDepartamento();
        pegarValorIntent();
    }

    private void pegarValorIntent(){
        Intent intent = getIntent();
        idDepartamento = intent.getIntExtra("extra_id_departamento", -1);
        if(idDepartamento > -1){
            carregarDepartamento(idDepartamento);
        }
    }

    private void carregarDepartamento(int idDepartamento){
        departamentoRepositorio.buscarDepartamento(idDepartamento, new RespositorioCallBack<Department>() {
            @Override
            public void onResponse(Department response) {
                binding.nomeCriarDepartamento.setText(response.getName());
                editarDepartment = response;
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("edicaodepartamento", "onFailure: falhou ao procurar" + t);
            }
        });
    }

    private void salvarDepartamento(){

        binding.buttonSalvarDepartamento.setOnClickListener(view -> {
            DepartamentRequest departamentRequest = getDepartamento();
            if(idDepartamento > -1){
                editarDepartment(idDepartamento, departamentRequest);
            }else{
                criarDepartamerto(departamentRequest);
            }

        });
    }

    private DepartamentRequest getDepartamento(){
        String nomedepartamento = binding.nomeCriarDepartamento.getText().toString();
        return new DepartamentRequest(nomedepartamento);
    }

    private void editarDepartment(int idDepartamento, DepartamentRequest departamentRequest){
        departamentoRepositorio.editaDepartamento(idDepartamento, departamentRequest, new RespositorioCallBack<Department>() {
            @Override
            public void onResponse(Department response) {
                Toast.makeText(CriarDepartamentoActivity.this, "edição feita com sucesso", Toast.LENGTH_LONG).show();
                finish();
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("edicaodepartamento", "onFailure: falha a edição");
            }
        });
    }

    private void criarDepartamerto(DepartamentRequest departamentRequest){
        departamentoRepositorio.criarDepartamento(departamentRequest, new RespositorioCallBack<Department>() {
            DepartamentRequest oque =departamentRequest;
            @Override
            public void onResponse(Department response) {
                response.getName();
                Toast.makeText(CriarDepartamentoActivity.this, "Salvo com sucesso", Toast.LENGTH_LONG);
                finish();
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("edicaodepartamento", "onFailure: falha ao salvar");

            }
        });
    }
}