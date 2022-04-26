package com.ipl.professorallocation.view.lista_departamento;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ipl.professorallocation.databinding.ItemListaDepartamentoBinding;
import com.ipl.professorallocation.model.Department;
import com.ipl.professorallocation.model.Professor;

import java.util.ArrayList;
import java.util.List;

public class ListaDepartamentoAdapter extends RecyclerView.Adapter<ListaDepartamentoAdapter.ViewHolder> {

    private List<Department> listDepartamento = new ArrayList<>();
    private CallBack callBack;
    public ListaDepartamentoAdapter(CallBack callBack){this.callBack = callBack;}

        public static class ViewHolder extends RecyclerView.ViewHolder {
            private final ItemListaDepartamentoBinding binding;

            public ViewHolder(ItemListaDepartamentoBinding binding){
                super(binding.getRoot());
                this.binding = binding;
            }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            ItemListaDepartamentoBinding binding = ItemListaDepartamentoBinding.inflate(LayoutInflater.from(viewGroup.getContext()),viewGroup,false);
            return new ViewHolder(binding);
        }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

            Department department = listDepartamento.get(position);
            viewHolder.binding.buttonDeleteDepartamento.setOnClickListener(view -> {});
            viewHolder.binding.buttonEditDepartamento.setOnClickListener(view -> {});
            viewHolder.binding.textNomeDepartamento.setText(department.getName());

    }

    public void addDepartament(List<Department> listDepartamento ){
        this.listDepartamento = listDepartamento;
        notifyDataSetChanged();
    }

    public void removerDepartament(Department departament){
        listDepartamento.remove(departament);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){ return  listDepartamento.size(); }

    public interface CallBack{
        void onDeleteClick(Department department);
        void onEditeClick(Department department);
    }
}
