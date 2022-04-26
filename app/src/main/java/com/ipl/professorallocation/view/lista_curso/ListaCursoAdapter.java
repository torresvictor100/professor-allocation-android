package com.ipl.professorallocation.view.lista_curso;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ipl.professorallocation.databinding.ItemListaCursoBinding;
import com.ipl.professorallocation.model.curso.Curso;


import java.util.ArrayList;
import java.util.List;


public class ListaCursoAdapter extends RecyclerView.Adapter<ListaCursoAdapter.ViewHolder> {

    private List<Curso> listCurso = new ArrayList<>();
    private CallBack callBack;
    public ListaCursoAdapter(CallBack callBack){this.callBack = callBack;}

        public static class ViewHolder extends RecyclerView.ViewHolder {
            private final ItemListaCursoBinding binding;

            public ViewHolder(ItemListaCursoBinding  binding){
                super(binding.getRoot());
                this.binding = binding;
            }
        }

    public void addCurso(List<Curso> listCurso){
        this.listCurso = listCurso;
        notifyDataSetChanged();
    }

    public void removerCurso(Curso curso){
        listCurso.remove(curso);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        ItemListaCursoBinding binding = ItemListaCursoBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Curso curso = listCurso.get(position);
        viewHolder.binding.buttonEditCurso.setOnClickListener(view -> {});
        viewHolder.binding.buttonDeleteCurso.setOnClickListener(view -> {});
        viewHolder.binding.nomeCurso.setText(curso.getName());
    }

    @Override
    public int getItemCount(){ return  listCurso.size(); }

    public interface CallBack{
        void onDeleteClick(Curso curso);
        void onEditeClick(Curso curso);
    }
}
