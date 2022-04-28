package com.ipl.professorallocation.view.criar_curso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ipl.professorallocation.data.CursoRepositorio;
import com.ipl.professorallocation.data.RespositorioCallBack;
import com.ipl.professorallocation.databinding.ActivityCriarCursoBinding;
import com.ipl.professorallocation.databinding.ActivityCriarProfessorBinding;
import com.ipl.professorallocation.databinding.ActivityListaCursoBinding;
import com.ipl.professorallocation.model.curso.Curso;
import com.ipl.professorallocation.model.curso.CursosRequest;

public class CriarCursoActivity extends AppCompatActivity {

    private ActivityCriarCursoBinding binding;
    private CursoRepositorio cursoRepositorio;
    private int idCurso = -1;
    private Curso editarCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCriarCursoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        cursoRepositorio = new CursoRepositorio();
        salvarCurso();
        pegarValorIntent();
    }

    private void pegarValorIntent(){
        Intent intent = getIntent();
        idCurso = intent.getIntExtra("extra_id_curso", -1);
        if(idCurso > -1){
            carregarCurso(idCurso);
        }
    }

    private void carregarCurso(int idCurso){
        cursoRepositorio.buscarCurso(idCurso, new RespositorioCallBack<Curso>() {
            @Override
            public void onResponse(Curso response) {
                binding.nomeCriarCurso.setText(response.getName());
                editarCurso = response;
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("editacurso", "onFailure: falhou ao procurar o curso");
            }
        });
    }

    private void salvarCurso(){
        binding.buttonCriarCurso.setOnClickListener(view -> {
            CursosRequest cursosRequest = getCurso();
            if (idCurso > -1){
                editarCurso(idCurso, cursosRequest);
            }else{
                criarCurso(cursosRequest);
            }

        });


    }

    private CursosRequest getCurso(){
        String nomeCurso = binding.nomeCriarCurso.getText().toString();
        return new CursosRequest(nomeCurso);
    }


    private void editarCurso(int idCurso, CursosRequest cursosRequest){
        cursoRepositorio.editaCurso(idCurso, cursosRequest, new RespositorioCallBack() {
            @Override
            public void onResponse(Object response) {
                Toast.makeText(CriarCursoActivity.this, "edição com sucesso", Toast.LENGTH_LONG).show();
                finish();
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("edicaocurso", "onFailure: falhou a edição");
            }
        });
    }

    private void criarCurso(CursosRequest cursosRequest){
        cursoRepositorio.criarCurso( cursosRequest, new RespositorioCallBack<Curso>() {
            @Override
            public void onResponse(Curso response) {
                Toast.makeText(CriarCursoActivity.this, "Salvo com sucesso", Toast.LENGTH_LONG);
                finish();
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("cadastrarprofessor", "onFailure: falha ao salvar");
            }
        });
    }
}