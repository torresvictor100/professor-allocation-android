//
//
//package com.ipl.professorallocation.view.criar_professor;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Adapter;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Toast;
//
//import com.ipl.professorallocation.data.DepartamentoRepositorio;
//import com.ipl.professorallocation.data.ProfessorRepositorio;
//import com.ipl.professorallocation.data.RespositorioCallBack;
//import com.ipl.professorallocation.databinding.ActivityCriarProfessorBinding;
//import com.ipl.professorallocation.model.Department;
//import com.ipl.professorallocation.model.Professor;
//import com.ipl.professorallocation.model.ProfessorRequest;
//
//import java.util.List;
//
//public class CriarProfessorActivity extends AppCompatActivity {
//
//    private  ActivityCriarProfessorBinding binding;
//    private ProfessorRepositorio professorRepositorio;
//    private DepartamentoRepositorio departamentoRepositorio;
//    private int idProfessor = -1;
//    private ArrayAdapter<String> arrayAdapterSpinner;
//    private Department department;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityCriarProfessorBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//        professorRepositorio = new ProfessorRepositorio();
//        departamentoRepositorio = new DepartamentoRepositorio();
//        salvarProfessor();
//        pegarValorIntent();
//        configuraSpinner();
//        listaDepartamento();
//    }
//
//    private void pegarValorIntent(){
//        Intent intent = getIntent();
//        idProfessor = intent.getIntExtra("extra_id_professor", -1);
//        if(idProfessor > -1){
//            carregarPorfessor(idProfessor);
//        }
//    }
//
//    private void listaDepartamento(){
//        departamentoRepositorio.listarDepartamento(new RespositorioCallBack<List<Department>>() {
//            @Override
//            public void onResponse(List<Department> response) {
//                //arrayAdapterSpinner.addAll(response);
//                Log.d("listadepartamento", "onResponse: sucesso a lista o departamento"+ response);
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                Log.d("listadepartamento", "onFailure: falaha a lista");
//            }
//        });
//    }
//
//    private void configuraSpinner(){
//        arrayAdapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 );
//        binding.departamentosSpinner.setAdapter(arrayAdapterSpinner);
//        arrayAdapterSpinner.addAll("EXATAS","HUMANAS","BIOLOGICAS");
//        binding.departamentosSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
//                //department = (String) binding.departamentosSpinner.getItemAtPosition(position);
//                Log.d("spinnerprofessor", "onItemSelected: deu certo"+ binding.departamentosSpinner.getItemAtPosition(position));
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//    }
//
//    private void carregarPorfessor(int idProfessor){
//        professorRepositorio.buscarProfessorPorId(idProfessor, new RespositorioCallBack<Professor>() {
//            @Override
//            public void onResponse(Professor response) {
//                binding.nomeTextSalva.setText(response.getName());
//                binding.cpfTextSalva.setText(response.getCpf());
//
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                Log.d("editaprofessor", "onFailure: falhou na ediçao");
//            }
//        });
//    }
//
//    private void salvarProfessor(){
//
//        binding.buttonSalvar.setOnClickListener(view -> {
//            ProfessorRequest professorRequest = getProfessor();
//            if(idProfessor > -1){
//                editarProfessor(idProfessor, professorRequest);
//            }else{
//                criarProfessor(professorRequest);
//            }
//
//        });
//    }
//
//    private ProfessorRequest getProfessor(){
//        String nomeprofessor =binding.nomeTextSalva.getText().toString();
//        String cpfProfessor= binding.cpfTextSalva.getText().toString();
//        int departamentpProfessor = department.getId();
//        return new ProfessorRequest(cpfProfessor, departamentpProfessor, nomeprofessor);
//
//    }
//
//    private void editarProfessor(int professorId,ProfessorRequest professorRequest){
//        professorRepositorio.editaProfessor(professorId, professorRequest, new RespositorioCallBack<Professor>() {
//            @Override
//            public void onResponse(Professor response) {
//                Toast.makeText( CriarProfessorActivity.this, "edição com sucesso", Toast.LENGTH_LONG).show();
//                finish();
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                Log.d("edicaoprofessor", "onFailure: falhou a edição");
//            }
//        });
//    }
//
//    private void criarProfessor(ProfessorRequest professorRequest){
//        professorRepositorio.criarProfessor( professorRequest,
//                new RespositorioCallBack<Professor>() {
//                    @Override
//                    public void onResponse(Professor response) {
//                        Toast.makeText( CriarProfessorActivity.this, "Sucesso salvo", Toast.LENGTH_LONG).show();
//                        finish();
//                    }
//
//                    @Override
//                    public void onFailure(Throwable t) {
//                        Log.d("cadastraprofessor", "onFailure: falha ao cadastras");
//                    }
//                });
//    }
//}