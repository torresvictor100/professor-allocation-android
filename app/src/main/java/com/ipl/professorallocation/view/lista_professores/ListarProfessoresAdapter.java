package com.ipl.professorallocation.view.lista_professores;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.ipl.professorallocation.databinding.ItemListaProfessorBinding;
import com.ipl.professorallocation.model.Professor;

import java.util.ArrayList;
import java.util.List;

public class ListarProfessoresAdapter extends RecyclerView.Adapter<ListarProfessoresAdapter.ViewHolder> {

    private List<Professor> listProfessor = new ArrayList<>();
    private CallBack callBack;
    public ListarProfessoresAdapter(CallBack callBack){
        this.callBack = callBack;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemListaProfessorBinding binding;

        public ViewHolder(ItemListaProfessorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        ItemListaProfessorBinding binding = ItemListaProfessorBinding.inflate(LayoutInflater.from(viewGroup.getContext()),viewGroup,false);
        return new ViewHolder(binding);
    }

    public void addProfessor(List<Professor> listProfessor){
        this.listProfessor = listProfessor;
        notifyDataSetChanged();
    };

    public void removerProfessor(Professor professor){
        listProfessor.remove(professor);
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        Professor professor = listProfessor.get(position);
        viewHolder.binding.buttonDelete.setOnClickListener(view -> {callBack.onDeleteClick(professor);});
        viewHolder.binding.buttonEdit.setOnClickListener(view -> {callBack.onEditeClick(professor);});
        viewHolder.binding.textNome.setText(professor.getName());
        viewHolder.binding.textCpf.setText(professor.getCpf());
        viewHolder.binding.textDepartamento.setText(professor.getDepartment().getName());

    }

    @Override
    public int getItemCount() {
        return listProfessor.size();
    }

    public interface CallBack{
        void onDeleteClick(Professor professor);
        void onEditeClick(Professor professor);
    };
}
