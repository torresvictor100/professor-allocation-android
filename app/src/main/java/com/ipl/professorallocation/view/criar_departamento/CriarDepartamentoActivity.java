package com.ipl.professorallocation.view.criar_departamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.ipl.professorallocation.data.DepartamentoRepositorio;
import com.ipl.professorallocation.data.RespositorioCallBack;
import com.ipl.professorallocation.databinding.ActivityCriarDepartamentoBinding;
import com.ipl.professorallocation.databinding.ActivityListarDepartamentoBinding;
import com.ipl.professorallocation.model.DepartamentRequest;
import com.ipl.professorallocation.model.Department;

import java.util.ArrayList;
import java.util.List;

public class CriarDepartamentoActivity extends AppCompatActivity {

    private ActivityCriarDepartamentoBinding binding;
    private DepartamentoRepositorio departamentoRepositorio;
    private int idDepartamento = -1;
    private Department editarDepartment;
    private ArrayAdapter<String> arrayAdapterSpinner;
    private String area;
    private List<String> listArea = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCriarDepartamentoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        departamentoRepositorio = new DepartamentoRepositorio();
        salvarDepartamento();
        pegarValorIntent();
        configuraSpinner();
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
                binding.criarSiglaDepartamento.setText(response.getSigla());
                binding.spinnerListaAreas.setSelection(posicaoArea(listArea, response.getArea()));
                editarDepartment = response;
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("edicaodepartamento", "onFailure: falhou ao procurar" + t);
            }
        });
    }

    private int posicaoArea(List<String> listArea, String area ){

        for (int i = 0; i < listArea.size() ; i++ ){
            if(listArea.get(i).equals(area) ){
                return i;
            }
        }
        return -1;
    }

    private void configuraSpinner(){
        arrayAdapterSpinner = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 );
        binding.spinnerListaAreas.setAdapter(arrayAdapterSpinner);
        arrayAdapterSpinner.addAll("BIOLOGICAS","HUMANAS","EXATAS");
        listArea.add("BIOLOGICAS"); listArea.add("HUMANAS"); listArea.add("EXATAS");
        binding.spinnerListaAreas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                area = (String) binding.spinnerListaAreas.getItemAtPosition(position);
                Log.d("spinnerarea", "onItemSelected: deu certo"+ binding.spinnerListaAreas.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d("spinnerarea", "onNothingSelected: falou a mostra");
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
        String areadepartamentyo = area;
        String sigladepartmaento = binding.criarSiglaDepartamento.getText().toString();
        return new DepartamentRequest(areadepartamentyo, nomedepartamento, sigladepartmaento);
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
            @Override
            public void onResponse(Department response) {
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