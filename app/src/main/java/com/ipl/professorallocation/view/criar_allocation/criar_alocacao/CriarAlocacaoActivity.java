package com.ipl.professorallocation.view.criar_allocation.criar_alocacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.ipl.professorallocation.data.AllocationRepositorio;
import com.ipl.professorallocation.data.CursoRepositorio;
import com.ipl.professorallocation.data.DepartamentoRepositorio;
import com.ipl.professorallocation.data.ProfessorRepositorio;
import com.ipl.professorallocation.data.RespositorioCallBack;
import com.ipl.professorallocation.databinding.ActivityCriarAlocacaoBinding;
import com.ipl.professorallocation.model.AllocationRequest;
import com.ipl.professorallocation.model.AllocationsItem;
import com.ipl.professorallocation.model.DepartamentRequest;
import com.ipl.professorallocation.model.Department;
import com.ipl.professorallocation.model.Professor;
import com.ipl.professorallocation.model.curso.Curso;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CriarAlocacaoActivity extends AppCompatActivity {

    private ActivityCriarAlocacaoBinding binding;
    private ArrayAdapter<Curso> arrayCursoAdapterSpinner;
    private ArrayAdapter<Professor> arrayProfessorAdapterSpinner;
    private ArrayAdapter<String> arrayDiaAdapterSpinner;
    private ProfessorRepositorio professorRepositorio;
    private CursoRepositorio cursoRepositorio;
    private AllocationRepositorio allocationRepositorio;
    private String dia;
    private List<String> listDia = new ArrayList<>();

    private Professor professor;
    private Curso curso;
    private int idAlocacao = -1;
    private AllocationsItem allocationsItemEditar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCriarAlocacaoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        allocationRepositorio = new AllocationRepositorio();
        professorRepositorio = new ProfessorRepositorio();
        cursoRepositorio = new CursoRepositorio();
        salvarAlocacao();
        pegarValorIntent();
        configurarSpinnerCurso();
        configurarSpinnerDia();
        configuraSpinnerProfessor();
        listCurso();
        listaProfessor();
    }

    private void pegarValorIntent(){
        Intent intent = getIntent();
        idAlocacao = intent.getIntExtra("extra_id_alocacao", -1);
        if(idAlocacao > -1){
            corregarAlocacao(idAlocacao);
        }
    }

    private void corregarAlocacao(int idAlocacao) {
        allocationRepositorio.buscarAllocation(idAlocacao, new RespositorioCallBack<AllocationsItem>() {
            @Override
            public void onResponse(AllocationsItem response) {
                binding.horarioDeInicio.setText(response.getStartHour().format(DateTimeFormatter.ofPattern("HH:mm")));
                binding.horarioDeFinal.setText(response.getEndHour().format(DateTimeFormatter.ofPattern("HH:mm")));
                binding.spinnerDiaDaSemana.setSelection(posicaoDia(listDia, response.getDayOfWeek()));

                allocationsItemEditar = response;

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void configuraSpinnerProfessor(){
        arrayProfessorAdapterSpinner = new ArrayAdapter<Professor>(this, android.R.layout.simple_list_item_1);
        binding.spinnerProfessor.setAdapter(arrayProfessorAdapterSpinner);
        binding.spinnerProfessor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                professor = (Professor) binding.spinnerProfessor.getItemAtPosition(position);
                Log.d("spinnerprofessoralocacao", "onItemSelected: item selecionado com sucesso");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void configurarSpinnerCurso(){
        arrayCursoAdapterSpinner = new ArrayAdapter<Curso>(this,android.R.layout.simple_list_item_1);
        binding.spinnerDeCurso.setAdapter(arrayCursoAdapterSpinner);
        binding.spinnerDeCurso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                curso = (Curso) binding.spinnerDeCurso.getItemAtPosition(position);
                Log.d("spinnercursoalocacao", "onItemSelected: intem selecionado com sucesso");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    private int posicaoDia(List<String> listDia, String dia){
        for(int i = 0; i< listDia.size(); i++){
            if(listDia.get(i).equals(dia)){
                return i;
            }
        }
        return -1;
    }

    private void configurarSpinnerDia(){
        arrayDiaAdapterSpinner = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 );
        binding.spinnerDiaDaSemana.setAdapter(arrayDiaAdapterSpinner);
        arrayDiaAdapterSpinner.addAll("MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY");
        listDia.add("MONDAY");listDia.add("TUESDAY");listDia.add("WEDNESDAY");listDia.add("THURSDAY");listDia.add("FRIDAY");listDia.add("SATURDAY");listDia.add("SUNDAY");
        binding.spinnerDiaDaSemana.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                dia = (String) binding.spinnerDiaDaSemana.getItemAtPosition(position);
                Log.d("spinnerdia", "onItemSelected: selecionado com sucesso");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void listCurso(){
        cursoRepositorio.listarCursos(new RespositorioCallBack<List<Curso>>() {
            @Override
            public void onResponse(List<Curso> response) {
                arrayCursoAdapterSpinner.addAll(response);
                if(idAlocacao > -1 ){
                    int posicaoCurso = arrayCursoAdapterSpinner.getPosition(allocationsItemEditar.getCourse());
                    binding.spinnerDeCurso.setSelection(posicaoCurso);
                }
                Log.d("listacurso", "onResponse: sucesso a lista o curso"+ response);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("listacurso", "onFailure: falaha a lista"+ t);
            }
        });
    }

    private void listaProfessor(){
        professorRepositorio.listarProfessores(new RespositorioCallBack<List<Professor>>() {
            @Override
            public void onResponse(List<Professor> response) {
                arrayProfessorAdapterSpinner.addAll(response);
                if(idAlocacao > -1){
                    int posicaoProfessor = arrayProfessorAdapterSpinner.getPosition(allocationsItemEditar.getProfessor());
                    binding.spinnerProfessor.setSelection(posicaoProfessor);
                }
                Log.d("listprofessor", "onResponse: sucesso a lista o Professor"+ response);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("listprofessor", "onFailure: falaha a lista");
            }
        });
    }

    private void salvarAlocacao(){
        binding.buttonSalvarAlocacao.setOnClickListener(view -> {
            AllocationRequest allocationRequest = getAlocacao();
            if(idAlocacao > -1 ){
                editarAlocacao(idAlocacao, allocationRequest);
            }else{
                criarAlocacao(allocationRequest);
            }
        });

    }

    private AllocationRequest getAlocacao(){
        String horaInicio = binding.horarioDeInicio.getText().toString();
        String horaFinal = binding.horarioDeFinal.getText().toString();
        LocalTime convertendoHoraInicio = LocalTime.parse(horaInicio, DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime convertendoHoraFinal = LocalTime.parse(horaFinal, DateTimeFormatter.ofPattern("HH:mm"));
        int cursoAlocacao = curso.getId();
        int professorAlocacao = professor.getId();
        String diaDaSemana = dia;
        return new AllocationRequest(cursoAlocacao, diaDaSemana,convertendoHoraInicio,convertendoHoraFinal, professorAlocacao );

    }

    private void editarAlocacao(int idAlocacao, AllocationRequest allocationRequest){
        allocationRepositorio.editarAllocation(idAlocacao, allocationRequest, new RespositorioCallBack<AllocationsItem>() {
            @Override
            public void onResponse(AllocationsItem response) {
                Toast.makeText(CriarAlocacaoActivity.this, "edição feita com sucesso", Toast.LENGTH_LONG);
                finish();

            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("falhanaedicao", "onFailure: falha a o editar");
            }
        });
    }

    private void criarAlocacao(AllocationRequest allocationRequest){
        allocationRepositorio.criarAllocation(allocationRequest, new RespositorioCallBack<AllocationsItem>() {
            @Override
            public void onResponse(AllocationsItem response) {
                Toast.makeText(CriarAlocacaoActivity.this, "Salvo com sucesso", Toast.LENGTH_LONG);
                finish();
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("editaralocacao", "onFailure: falha ao salvar a alocacao");
            }
        });
    }
}